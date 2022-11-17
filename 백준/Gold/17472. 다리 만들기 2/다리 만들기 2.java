
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int n, m, sNum;
    static int[][] map; //지도 정보
    static int[] parent;
    static boolean[][] visited;//bfs 방문 체크 배열
    static PriorityQueue<bEdge> queue;//다리 정보 저장할 큐
    static ArrayList<ArrayList<int[]>> sumList;//모든 섬 정보 저장할 리스트
    static ArrayList<int[]> mList; // 1개 섬 정보 저장할 리스트

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        //map 정보 저장하기
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        sNum = 1;
        sumList = new ArrayList<>();
        visited = new boolean[n][m];
        //bfs로 섬 분리
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    BFS(i, j); //
                    sNum++; //1번섬, 2번섬으로 구분될 수 있도록 넣어줄거임
                    sumList.add(mList);
                }
            }
        }

        queue = new PriorityQueue<>();


        //연결할 다리가 있는지 확인(연결할 수 있는 다리이면 에지리스트에 다리 정보 저장)
        for (int i = 0; i < sumList.size(); i++) {
            ArrayList<int[]> now = sumList.get(i); //1개 섬 정보
            for (int j = 0; j < now.size(); j++) {
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int nowNumber = map[r][c];

                //상하좌우 방향 확인하면서 다리를 연결할 수 있는 조건인지 확인(다리길이2이상, 같은섬X, 다리 끝이 섬인지)
                for (int d = 0; d < 4; d++) {
                    int tempR = dr[d];
                    int tempC = dc[d];
                    int bLength = 0; //다리 길이

                    while (r + tempR >= 0 && r + tempR < n && c + tempC >= 0 && c + tempC < m) {
                        // 이동한 섬이 같은 섬 구역이면 패스
                        if (map[r + tempR][c + tempC] == nowNumber) {
                            break;
                        } else if (map[r+tempR][c+tempC] != 0) {
                            // 다른 섬 구역인 경우
                            if (bLength > 1) {
                                //다리 길이가 2이상인 경우 에지리스트에 저장하기
                                queue.add(new bEdge(nowNumber, map[r + tempR][c + tempC], bLength));
                            }
                            break;
                        } else {
                            // 바다인 경우
                            bLength ++;
                        }

                        //같은 방향으로 계속 이동
                        if (tempR < 0) {
                            tempR --;
                        } else if (tempR > 0) {
                            tempR ++;
                        } else if (tempC > 0) {
                            tempC++;
                        } else if (tempC < 0) {
                            tempC--;
                        }
                    }
                }
            }

        }


        //대표노드 초기화
        parent = new int[sNum + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        //다리 정보 가지고 최소 신장 트리 알고리즘 수행
        int useEdge = 0;
        int result = 0; //가중치 합 결과 변수
        while (!queue.isEmpty()) {
            bEdge now = queue.remove();
            //대표노드가 같지 않으면 집합
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.v;
                useEdge++;
            }
        }


        // 출력
        if (useEdge == sNum - 2) {
            System.out.println(result);
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

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        mList = new ArrayList<>(); //1개의 섬 정보가 저장된 리스트(다른 섬에서는 매번 초기화)

        int[] start = {i, j};
        queue.add(start);
        mList.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;

        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            int r = now[0];
            int c = now[1];
            //네 방향 탐색
            for (int d = 0; d < 4; d++) {
                int tempR = r + dr[d];
                int tempC = c + dc[d];

                if (tempR >= 0 && tempR < n && tempC >= 0 && tempC < m) {
                    //현재 방문한 적 없고 바다가 아니면 같은 섬으로 취급하기
                    if (!visited[tempR][tempC] && map[tempR][tempC] != 0) {
                        int[] temp = {tempR, tempC};
                        queue.add(temp);
                        mList.add(temp);
                        visited[tempR][tempC] = true;
                        map[tempR][tempC] = sNum;
                    }
                }
            }

        }
    }
}

class bEdge implements Comparable<bEdge> {
    int s;
    int e;
    int v;

    bEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(bEdge o) {
        return this.v - o.v;
    }

    @Override
    public String toString() {
        return "bEdge{" +
                "s=" + s +
                ", e=" + e +
                ", v=" + v +
                '}';
    }
}