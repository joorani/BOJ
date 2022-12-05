
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n, k;
    static boolean[] visited; //방문체크 배열(최단시간이므로 한 번 방문한 곳은 재방문하지 않는 것이 효율적)
    static int[] depth; // 시간저장 배열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        visited = new boolean[1000001];
        depth = new int[1000001];

        if (n == k) {
            System.out.println("0");
        } else {
            BFS(n);
        }
    }

    private static void BFS(int p) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(p);
        depth[p] = 0;
        visited[p] = true;

        while(!queue.isEmpty()) {
            int now = queue.remove();
            //now + 1, now -1, now * 2
            int[] nextP = {now + 1, now -1, now * 2};
            for (int i = 0; i < 3; i++) {
                int next = nextP[i];
                if (next >= 0 && next<= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    depth[next] = depth[now] + 1;
                }
                if (next == k) {
                    System.out.println(depth[k]);
                    return;
                }
            }

        }
    }
}
