
import jdk.jshell.SnippetEvent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    //6가지 이동 케이스를 표현하기 위한 배열(a->b, a->c, b->a, b->c, c->a, c->b)
    static int[] sender = {0,0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited; // a, b 무게만 있으면 c의 무게가 고정되므로 2개만 체크
    static boolean[] answer;
    static int[] now; //데이터 값 저장할 배열(통이 수용 가능한 부피)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();

        visited = new boolean[201][201]; //a,b,c 최대 용량이 200
        answer = new boolean[201];

        BFS();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i]) System.out.print(i + " ");
        }
    }

    private static void BFS() {
        Queue<AB> queue = new LinkedList<>();
        queue.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!queue.isEmpty()) {
            AB p = queue.remove();
            int a = p.a;
            int b = p.b;
            int c = now[2]-a-b;

            //6가지 케이스 반복
            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                //가능한 용량을 초과해서 물이 넘칠 떄
                if (next[receiver[i]] > now[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]];
                    next[receiver[i]] = now[receiver[i]]; //최대용량 만큼만 저장
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    queue.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true; //1번쨰 물통 비어져 있으면 3번째 물통 양 저장
                    }
                }
            }
        }
    }

}

class AB {
    int a;
    int b;

    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }
}