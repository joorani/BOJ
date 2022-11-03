
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[] parent;
    static ArrayList<Integer>[] party;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사람수, 파티 수
        int n = sc.nextInt();
        int m = sc.nextInt();

        //진실을 아는 사람 수 및 데이터 저장하기
        int t = sc.nextInt();
        int[] trueP = new int[t];
        for (int i = 0; i < t; i++) {
            trueP[i] = sc.nextInt();
        }

        // 대표노드 자기 자신으로 초기화
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        //파티 데이터 저장
        party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            int partySize = sc.nextInt();
            for (int j = 0; j < partySize; j++) {
                party[i].add(sc.nextInt());
            }
        }

        //각 파티에 참여한 사람들을 1개의 그룹으로 만들기
        for (int i = 0; i < m; i++) {
            int firstPeople = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        //각 파티의 대표 노드와 진실을 아는 사람들의 대표 노드가 같다면 과장할 수 없다.
        for (int i = 0; i < m; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);
            for (int j = 0; j < trueP.length; j++) {
                if (find(cur) == find(trueP[j])) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) result++;
        }

        //결과 출력
        System.out.println(result);
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }
}
