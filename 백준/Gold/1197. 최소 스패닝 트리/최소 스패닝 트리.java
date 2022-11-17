import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static PriorityQueue<pEdge> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //노드 수, 에지 수 입력받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //에지 리스트, 대표노드배열 초기화
        q = new PriorityQueue<>(); // 자동정렬하기 위해서 우선순위큐 사용
        parent = new int[n+1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        //에지 리스트에 데이터 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e= Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            q.add(new pEdge(s, e, v));
        }

        int useEdge = 0; // n-1번 반복해야 하므로 횟수 카운트 할 변수
        int answer = 0; // 정답 배열

        while (useEdge < n - 1) {
            pEdge now = q.remove();
            //대표 노드가 같지 않으면 union 연산을 수행
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                answer += now.v;
                useEdge++;
            }
        }
        //정답 출력
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int node) {
        if (node == parent[node]) {
            return node;
        } else {
            return parent[node] = find(parent[node]);
        }
    }

}

class pEdge implements Comparable<pEdge> {

    int s;
    int e;
    int v;

    public pEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(pEdge o) {
        return this.v - o.v; // 가중치 기준 오름차순 정렬
    }
}