
import java.util.Scanner;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        //parent 배열 자기 자신으로 초기화
        parent = new int[n+1];
        for (int i = 0; i <= n ; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (question == 0) {
                //집합 합치기
                union(a, b);
            } else {
                //두 원소가 같은 집합에 포함되어 있는지를 확인
                if (checkSame(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
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

    private static boolean checkSame(int a, int b) {
       return find(a) == find(b);
    }
}
