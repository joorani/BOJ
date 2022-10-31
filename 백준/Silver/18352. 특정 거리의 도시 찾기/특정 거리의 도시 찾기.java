

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //인접리스트, 방문한 노드 이동거리 저장배열
    static ArrayList<Integer>[] alist;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        // n(도시의 개수), m(도로의 개수), k(거리 정보), x(출발 도시 번호)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());


        //인접리스트, 방문한 노드 이동거리 저장배열 초기화
        visited = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            visited[i] = -1; //음수로 초기화, 음수이면 방문하지 않았음을 의미한다.
        }

        alist = new ArrayList[n+1];
        for (int i = 1; i < n+1; i++) {
            alist[i] = new ArrayList<Integer>();
        }

        //데이터 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            alist[s].add(e);
        }
        
        BFS(x);
        List<Integer> answer = new ArrayList<>(); //정답 출력배열
        //출력
        for (int i = 1; i <= n; i++) {
            if (visited[i] == k) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(answer);//오름차순 정렬
            for (int value : answer) {
                System.out.println(value);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 0;

        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (int i : alist[now]) {
                //음수이면 방문하지 않은 노드임
                if (visited[i] < 0) {
                    queue.add(i);
                    visited[i] = visited[now] + 1;
                }
            }
        }
        
    }
}
