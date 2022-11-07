
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static EdgeCity edges[];
    static long[] distance;
    static int n, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new EdgeCity[m+1];
        distance = new long[n+1];

        //최단거리 배열 초기화하기
        Arrays.fill(distance, Integer.MAX_VALUE);

        //에지 리스트에 데이터 저장하기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new EdgeCity(start, end, time);
        }

        //벨만 포드 알고리즘 수행하기
        distance[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                EdgeCity edge = edges[j];
                // 더 작은 최단 거리가 있을 떄 업데이트하기
                if (distance[edge.start] != Integer.MAX_VALUE
                        && distance[edge.end] > distance[edge.start] + edge.value) {
                    distance[edge.end] = distance[edge.start] + edge.value;
                }
            }
        }

        // 음수 사이클 존재 여부 확인
        boolean mCycle = false;
        for (int i = 0; i < m; i++) {
            EdgeCity edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end] > distance[edge.start] + edge.value) {
                mCycle = true;
            }
        }
        //출력하기
        if (!mCycle) {
            for (int i = 2; i <= n; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }
}

//edge class
class EdgeCity {
    int start;
    int end;
    int value;

    public EdgeCity(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}