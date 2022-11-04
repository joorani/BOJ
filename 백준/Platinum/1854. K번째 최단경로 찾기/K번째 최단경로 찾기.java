
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 노드개수, 경로개수, 최단경로 k번째
        int n, m, k;
        int[][] w= new int[1001][1001]; //그래프 저장 인접 행렬

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //최단 경로 저장할 우선순위 큐 배열
        PriorityQueue<Integer>[] distanceQ = new PriorityQueue[n+1];
        //내림차순 정렬하기
        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1: -1;
            }
        };
        for (int i = 0; i < n + 1; i++) {
            distanceQ[i] = new PriorityQueue<>(k, cp); //초기용량 k개를 가진 우선순위큐로 초기화된다.
        }

        //데이터 입력받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            w[a][b] = c;
        }

        //다익스트라 알고리즘 수행하기
        PriorityQueue<City> q = new PriorityQueue<>();
        //출발노드
        q.add(new City(1, 0));
        distanceQ[1].add(0);//출발노드의 최단경로 update;

        while (!q.isEmpty()) {
            City city = q.remove();
            int now = city.vertex;
            int cost = city.value;
            //연결된 모든노드 탐색
            for (int adjCity = 1; adjCity <= n; adjCity++) {

                if (w[now][adjCity] != 0) {
                //연결되어 있는 경우
                    //큐에 저장된 경로가 k개가 안되면 그냥 추가
                    if (distanceQ[adjCity].size() < k) {
                        distanceQ[adjCity].add(cost + w[now][adjCity]);
                        q.add(new City(adjCity, cost + w[now][adjCity]));
                    }
                    // 저장된 경로가 k개 이상일때
                    else if (distanceQ[adjCity].peek() > w[now][adjCity] +cost) {
                        distanceQ[adjCity].remove(); //가장 큰 값 삭제
                        distanceQ[adjCity].add(w[now][adjCity] + cost);
                        q.add(new City(adjCity, cost + w[now][adjCity]));
                    }
                }
            }
        }

        //출력하기
        for (int i = 1; i <= n; i++) {
            if (distanceQ[i].size() == k) {
                System.out.println(distanceQ[i].peek());
            } else {
                System.out.println("-1");
            }
        }
    }
}

class City implements Comparable<City>{
    int vertex;
    int value;

    public City(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }
    
    //오름차순 정렬
    @Override
    public int compareTo(City o) {
        return this.value < o.value? -1 : 1;
    }
}