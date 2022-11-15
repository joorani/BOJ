
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ForkJoinPool;

//케빈 베이컨의 6단계 법칙
public class Main {
    static int n,m;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 유저의 수, 친구 관계 수
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //인접행렬 초기화
        distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001;
                }
            }
        }

        //데이터 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            distance[s][e] = 1;
            distance[e][s] = 1;
        }

        //플로이드 워셜 알고리즘 수행하기

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        //출력하기
        int min = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += distance[i][j];
            }
            if (min > sum) {
                min = sum;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
