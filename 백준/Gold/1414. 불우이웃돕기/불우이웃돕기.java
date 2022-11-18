

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, lanSum;
    static int[] parent;
    static PriorityQueue<lEdge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        queue = new PriorityQueue<>();
        //에지리스트 만들기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] chars = st.nextToken().toCharArray();
            for (int j = 0; j < n; j++) {
               int temp = 0;
                if (chars[j] >= 'a' && chars[j] <= 'z') {
                    temp = chars[j]-'a' + 1;
                } else if (chars[j] >= 'A' && chars[j] <= 'Z') {
                    temp = chars[j] - 'A' + 27;
                }

                lanSum += temp; // 총 랜선 길이 저장하기
                if (i != j && temp != 0) {
                    queue.add(new lEdge(i, j, temp));
                }
            }
        }
        //대표노드 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int result = 0;
        int useEdge = 0;
        //최소신장트리 알고리즘 수행하기
        while (!queue.isEmpty()) {
            lEdge now = queue.remove();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }

        //정답 출력
        if (useEdge == n - 1) {
            System.out.println(lanSum - result);
        } else {
            System.out.println("-1");
        }
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

class lEdge implements Comparable<lEdge>{
    int s;
    int e;
    int v;

    public lEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(lEdge o) {
        return this.v - o.v;
    }
}
