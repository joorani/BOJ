
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 데이터 저장 인접리스트, 진입 차수 배열, 자기 자신 짓는데 걸리는 시간 저장 배열
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            A.add(new ArrayList<>());
        }

        int[] indegree = new int[n+1];
        int[] buildTime = new int[n+1];

        //인접리스트 데이터 저장하기
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            buildTime[i] = time;
            while (true) {
                int preTemp = Integer.parseInt(st.nextToken());
                if (preTemp == -1) {
                    break;
                }
                A.get(preTemp).add(i);
                indegree[i]++; //진입 차수 배열 초기화
            }
        }

        // 위상정렬 수행하기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        //결과 출력 배열
        int[] result = new int[n+1];
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (int next : A.get(now)) {
                indegree[next]--;
                //시간 update
                result[next] = Math.max(result[next], result[now] + buildTime[now]);
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        //출력
        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]+buildTime[i]);
        }
    }

}
