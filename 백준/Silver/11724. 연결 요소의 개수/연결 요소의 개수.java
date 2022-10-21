

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] data;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //n(노드의 개수), m(간선의 개수)
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 데이터 담을 인접리스트, 방문 배열 선언
        data = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // 인접리스트 초기화
        for (int i = 1; i <= n; i++) {
            data[i] = new ArrayList<Integer>();
        }
        
        // 데이터 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            data[s].add(e);
            data[e].add(s); // 무방향이므로 양방향으로 처리하기
        }

        int result = 0; // 결과값 변수

        //방문하지 않은 노드가 없을 때까지 반복하기 1~n
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                result ++;
                DFS(i);
            }
        }
        //결과 출력
        System.out.println(result);

    }

    private static void DFS(int v) {
        if (visited[v]) return;
        visited[v] = true;
        for (int i : data[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}
