

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //DFS 수행하면서 리프노드 개수 세다가 삭제 노드 만나면 탐색 중지
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int answer = 0; //리프 노드개수 저장 변수
    static int deleteNode = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // tree 초기화
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        //tree 데이터 저장하기
        int root = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t == -1) {
                root = i;
            } else {
                tree[t].add(i);
                tree[i].add(t);
            }
        }

        visited = new boolean[n];
        deleteNode = sc.nextInt();
        if (deleteNode == root) {
            System.out.println('0');
        } else {
            DFS(root);
            System.out.println(answer);
        }
    }

    private static void DFS(int node) {
        visited[node] = true;
        int childCnt = 0;
        for (int no : tree[node]) {
            if (!visited[no] && no != deleteNode) {
                childCnt ++;
                DFS(no);
            }
        }
        if (childCnt == 0) {
            answer ++;
        }
    }

}
