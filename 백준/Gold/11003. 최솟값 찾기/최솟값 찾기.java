
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * deque 이용해서 정렬하는 문제 (시간복잡도 O(n))
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 버퍼에 넣고 한 번에 출력하기 위해 buffredWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // N(데이터 개수), L(최솟값 범위) 입력받기
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        //데이터를 담을 덱 자료구조 선언
        Deque<Node> myDeque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            //새로운 값이 들어올 때마다 정렬 대신 현재 수 보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            // 덱의 마지막 값이 현재 들어올 값보다 크면 덱에서 제거한 후 값을 추가한다.
            while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
                myDeque.removeLast();
            }
            // 값 추가
            myDeque.addLast(new Node(now, i));
            // L(범위)에서 벗어난 인덱스의 값은 덱에서 제거한다.
            if (myDeque.getFirst().index <= i - L) {
                myDeque.removeFirst();
            }
            //덱의 첫번째 데이터 값 결과 버퍼에 담기
            bw.write(myDeque.getFirst().value + " ");
        }
        bw.flush(); //버퍼에 남아있는 데이터 출력시킴(버퍼 비워주는 동작)
        br.close();
    }

    static class Node {
        public int value;
        public int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
