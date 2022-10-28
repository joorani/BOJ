
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // n(재료의개수), A(인접리스트), lcm(최소공배수), v(각 노드값 저장 배열), visited(방문확인배열)

    static ArrayList<aNode>[] A;
    static boolean[] visited;
    static long[] v;
    static long lcm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        lcm = 1; //최소공배수
        v = new long[n];
        visited = new boolean[n];

        //인접리스트 초기화
        A = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            A[i] = new ArrayList<aNode>();
        }

        //데이터 입력받기
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            A[a].add(new aNode(b, p, q));
            A[b].add(new aNode(a, q, p));
            lcm *= (p * q) / gcd(p, q);

        }

        //0번 노드에 최소 공배수 저장하기
        v[0] = lcm;
        DFS(0);
        //DFS 수행 후 v 배열에 각 노드이 값이 저장되어 있는 상태임, v 배열의 최대공약수 구하기
        long mgcd = v[0];
        for (int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, v[i]);
        }

        //출력하기
        // 값이 저장된 배열의 각 값들을 최대공약수로 나눈 값 출력하기
        for (int i = 0; i < n; i++) {
            System.out.print(v[i]/mgcd + " ");
        }

    }

    private static void DFS(int node) {
        visited[node] = true;
        for (aNode aNode : A[node]) {
            int next = aNode.getB();
            if (!visited[next]) {
                v[next] = v[node] * aNode.getQ() / aNode.getP(); //주어진 비율로 노드 값 갱신.
                DFS(next);
            }
        }
    }

    //최대공약수 구하는 함수
    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}

//다음노드, 비율 저장 노드
class aNode {

    int b;
    int p;
    int q;

    public aNode(int b, int p, int q) {
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}
