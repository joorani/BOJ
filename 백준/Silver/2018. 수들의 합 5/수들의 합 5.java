
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        //1~N까지 돌면서 투 포인터 사용해 sum 확인
        int sum = 1;
        int cnt = 1; // N 1개만 뽑는 경우의 수
        int startIdx = 1;
        int endIdx = 1;

        while (endIdx != N) {
            if (sum == N) {
                cnt ++;
                endIdx++;
                sum += endIdx;
            } else if (sum < N) {
                endIdx++;
                sum += endIdx;
            } else {
                sum -=startIdx;
                startIdx ++;
            }
        }
        System.out.println(cnt);

    }
}
