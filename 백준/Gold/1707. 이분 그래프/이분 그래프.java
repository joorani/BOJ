
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] alist; //인접리스트
    static boolean[] visited;
    static int[] check; // 짝,홀 두 집합 저장 배열
    static boolean isEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // k(테스트 케이스 개수)
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < k; i++) {
            //v( 정점의 개수), e(간선의 개수)
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            alist = new ArrayList[v+1];
            visited = new boolean[v+1];
            check = new int[v+1];
            isEven = true;

            for (int j = 1; j <= v; j++) {
                alist[j] = new ArrayList<>();
            }

            //데이터 입력받기
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                alist[start].add(end);
                alist[end].add(start);
            }

            //모든 노드들을 돌면서 탐색 시작
            for (int j = 1; j <= v; j++) {
                if (isEven) {
                    DFS(j);
                } else {
                    break;
                }
            }
            //출력
            if (isEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static void DFS(int node) {
        visited[node] = true;
        for (int i : alist[node]) {
            if (!visited[i]) {
                check[i] = (check[node] + 1) % 2;
                DFS(i);
            }
            //이미 방문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님
            else if (check[node] == check[i]) {
                isEven = false;
            }
        }
    }

}
