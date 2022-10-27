import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();
        long max = sc.nextLong();

        // 최대값과 최솟값 차이만큼 배열 선언하기
        boolean[] check = new boolean[(int) (max - min + 1)];

        // 2의 제곱수인 4부터 max 보다 작거나 같은 값까지 반복
        for (long i = 2; i*i <= max; i++) {
            long pow = i * i; //제곱수
            long startIdx = min/pow;
            if (min % pow != 0) {
                startIdx ++;//나머지가 있으면 1을 더해야 min보다 큰 제곱수에서 시작됨.
            }
            for (long j = startIdx; pow * j <= max; j++) {
                check[(int) ((j*pow)-min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
