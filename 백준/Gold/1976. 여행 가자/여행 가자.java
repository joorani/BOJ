
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //도시의 수, 여행 계획에 속한 도시들의 수
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        //도시 연결 데이터 배열, 여행 계획 도시 저장 배열 선언
        int[][] dosi = new int[n+1][n+1];
        int[] route = new int[m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dosi[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        //대표 노드 초기화
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 인접행렬 돌면서 연결되어 있으면 union 수행
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dosi[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 도시들이 1개의 대표 도시로 연결되어 있는지 확인하기
        int index = find(route[1]);
        for (int i = 2; i < route.length; i++) {
            if (index != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}
