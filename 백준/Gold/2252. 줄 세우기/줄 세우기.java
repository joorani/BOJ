
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        //학생 수, 비교 횟수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //데이터 저장 인접리스트, 진입차수 배열
        ArrayList<Integer>[] alist = new ArrayList[n+1];
        int[] indegree = new int[n+1];
        for (int i = 1; i <= n; i++) {
            alist[i] = new ArrayList<>();
        }

        //데이터 입력 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            alist[a].add(b);
            indegree[b] ++; //진입차수 배열 ++;
        }

        // 위상 정렬 수행
        Queue<Integer> queue = new LinkedList<>();
        // 집입 차수 배열 값이 0인 노드 큐에 삽입하기
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.remove();
            System.out.print(now + " ");
            for (int i : alist[now]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
    }
}
