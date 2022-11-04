
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Edge>[] alist; //데이터 저장 인접 리스트
    static boolean[] visited; //방문체크 배열
    static int[] distance; //최단거리 저장배열
    static PriorityQueue<Edge> queue = new PriorityQueue<>(); //value가 작은 노드를 선택하게 하기 위함.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정점 개수, 간선 개수
        int V = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        // 출발 노드
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());

        //인접리스트 초기화하기
        alist = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            alist[i] = new ArrayList<Edge>();
        }

        //방문배열, 최단거리 배열 초기화
        visited = new boolean[V+1];
        distance = new int[V+1];
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE; //최대값으로 배열 최기화
        }

        // 인접리스트에 데이터 입력받기
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            alist[u].add(new Edge(v, w));
        }

        //출발노드 queue에 넣고 다익스트라 알고리즘 수행하기
        queue.add(new Edge(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Edge nowEdge = queue.remove();
            int now = nowEdge.vertex;
            if (visited[now]) continue; //방문한 적있는 노드는 pass;
            visited[now] = true; //방문처리하기

            //현재 노드와 연결된 인접리스트 탐색하면서 최단거리 update하기
            for (Edge edge : alist[now]) {
                int next = edge.vertex;
                int value = edge.value;

                if (distance[now] + value < distance[next]) {
                    distance[next] = distance[now]+ value;
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }

        //distance 출력하기
        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}

//도착 노드와 가중치 클래스 (가중치 오름차순으로 우선순위큐 정렬하기)
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
