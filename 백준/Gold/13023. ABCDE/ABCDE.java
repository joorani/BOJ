

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] data;
    static boolean[] visited;
    static boolean arrive = false; // depth 5이상되면 true
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드의 개수, 에지의 개수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        data = new ArrayList[n];
        visited = new boolean[n];

        // data 리스트 초기화
        for (int i = 0; i < n; i++) {
            data[i] = new ArrayList<>();
        }

        // 데이터 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            data[s].add(e);
            data[e].add(s);
        }

        for (int i = 0; i < n; i++) {
            DFS(i, 1); //depth 1부터 시작
            if (arrive) break;
        }
        if (arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    private static void DFS(int v, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[v] = true;
        for (int i : data[v]) {
            if (!visited[i]) {
                DFS(i, depth+1);
            }
        }
        //back
        visited[v] = false;
    }
}
