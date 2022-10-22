
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board; //데이터 입력받는 2차원 배열
    static boolean[][] visited; //방문 체크 배열
    //4방향 확인 배열
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n; //행 길이
    static int m; //열 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // n(행길이), m(열길이)
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 2차원 행렬 초기화, 방문 체크 배열 초기화
        board = new int[n][m];
        visited = new boolean[n][m];

        //데이터 입력받기
        for (int i = 0; i < n; i++) {

//            st = new StringTokenizer(br.readLine());
//            String line = st.nextToken();
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        BFS(0, 0);
        System.out.println(board[n-1][m-1]);
    }

    private static void BFS(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{r, c});
        visited[r][c] = true; //방문체크

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            //now 노드의 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(x >= 0 && x < n && y >= 0 && y < m) { // board 범위 내인지 확인
                    if (board[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        board[x][y] = board[now[0]][now[1]]+1; // 깊이 업데이트하기
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
