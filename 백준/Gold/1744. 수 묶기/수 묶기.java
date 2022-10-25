
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    // 큰 수끼리 묶어서 곱한 값을 수의 합이 최대가 나올 수 있음
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 양수 우선순위 큐, 음수 우선순위 큐, 0의 개수카운트 변수, 1의 개수 카운트 변수
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); //최대힙
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();

        int zeroCnt = 0;
        int oneCnt = 0;

        //4개의 그룹으로 분리해 저장하기
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();

            if (data > 1) {
                plusPq.add(data);
            } else if (data == 1) {
                oneCnt ++;
            } else if (data == 0) {
                zeroCnt++;
            } else {
                minusPq.add(data);
            }
        }

        int result = 0; //결과값 변수

        // 양수 처리
        while (plusPq.size() > 1) {
            int first = plusPq.remove();
            int second = plusPq.remove();
            result += (first * second);
        }
        //1개 남아있는 경우
        if (!plusPq.isEmpty()) {
            result += plusPq.remove();
        }

        //음수 처리
        while (minusPq.size() > 1) {
            int first = minusPq.remove();
            int second = minusPq.remove();
            result += (first * second);
        }
        // 1개 남아있는 경우
        if (!minusPq.isEmpty()) {
            if (zeroCnt == 0) {
                result += minusPq.remove();
            }
        }

        // 1처리
        result += oneCnt;

        //출력
        System.out.println(result);



    }

}
