import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.ForkJoinPool;

public class Main {
    static int n, m;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        //도시 개수, 노선 개수 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        //노선 데이터 저장 할 인접행렬 초기화
        distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001; //비용이 가능한 범위의 최대값으로 초기화
                }
            }

        }

        //노선 데이터 저장하기
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (distance[a][b] > c) distance[a][b] = c;
        }

        // 플로이드-워셜 알고리즘 실행
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        //출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] == 10000001) {
                    System.out.print("0 ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
