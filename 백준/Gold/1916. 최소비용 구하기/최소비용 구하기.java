import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//11.4(금) 다익스트라 알고리즘
public class Main {
    static ArrayList<Edge>[] alist;
    static boolean[] visited;
    static int[] cost; //최소 비용 저장 배열
    static PriorityQueue<Edge> queue = new PriorityQueue<>();
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //도시의 개수, 버스의 개수
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        //인접리스트 초기화
        alist = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            alist[i] = new ArrayList<Edge>();
        }

        visited = new boolean[n+1];
        //최소 비용 저장 배열 초기화
        cost = new int[n+1];
        for (int i = 0; i <=n; i++) {
            cost[i] = Integer.MAX_VALUE; //최대 값으로 초기화
        }

        //인접리스트 데이터 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            alist[s].add(new Edge(e, c));
        }

        //출발 노드, 도착 노드
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //다익스트라 알고리즘 수행하기
        cost[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge nowEdge = queue.remove();
            int now = nowEdge.vertex;
            if (!visited[now]) {
                visited[now] = true;
                for (Edge e : alist[now]) {
                    int next = e.vertex;
                    int value = e.value;
                    //최소 비용으로 업데이트하기
                    if (!visited[next] && cost[now] + value < cost[next]) {
                        cost[next] = cost[now]+value;
                        queue.add(new Edge(next, cost[next]));
                    }
                }
            }
        }

        //도착지점 비용 출력하기
        System.out.println(cost[end]);
    }


}
class Edge implements Comparable<Edge>{
    int vertex;
    int value;

    public Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}

