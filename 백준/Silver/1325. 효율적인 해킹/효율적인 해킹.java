
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //인접리스트, 방문 처리배열
    static ArrayList<Integer>[] alist;
    static boolean[] visited;
    static int[] answer; //거리 저장 배열

    public static void main(String[] args) throws IOException {
        //n(컴퓨터 개수), m(간선 개수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //초기화 작업
        alist = new ArrayList[n+1];
        for (int i = 1; i <=n; i++) {
            alist[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            alist[s].add(e);
        }

        answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            BFS(i); //1~n까지 모든 노드 탐색
        }

        // answer 배열의 max 값만 출력
        int maxValue = 0;
        for (int i = 1; i <= n; i++) {
            if (maxValue < answer[i]) {
                maxValue = answer[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (answer[i] == maxValue) {
                System.out.print(i + " ");
            }
        }

    }
    
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (int a : alist[now]) {
                if (!visited[a]) {
                    queue.add(a);
                    visited[a] = true;
                    answer[a] ++;
                }
            }
        }
    }
}
