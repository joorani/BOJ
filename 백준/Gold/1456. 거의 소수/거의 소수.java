

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 소수의 N제곱 수의 범위 min~max에 있는 것들만 count
        long min = sc.nextLong();
        long max = sc.nextLong();

        int count = 0; //결과값 출력

        long[] data = new long[10000001]; // 10**7제곱까지
        //배열 초기화하기
        for (int i = 2; i < data.length; i++) {
            data[i] = i;
        }

        //에라토스테네스 체 수행
        for (int i = 2; i <= Math.sqrt(data.length); i++) {
            if (data[i] == 0) continue;
            //배수 지우기
            for (int j = i + i; j < data.length; j= j+i) {
                data[j] = 0;
            }
        }

        // 구한 소수 돌면서 소수의 n 제곱근이 범위에 들어오면 count++
        // n 제곱을 하면 long 범위를 초과하는 경우가 발생한다. 계산 오류를 방지하려면 나눈 값으로 범위를 비교

        for (int i = 2; i < data.length; i++) {
            if (data[i] != 0) {
                long prime = data[i]; //소수 2, 3, 5, 7 ...
                while ((double)data[i] <= (double) max / (double) prime) {
                    if ((double)data[i] >= (double)min / (double)prime) {
                        count++;
                    }
                    prime *= data[i];
                }
            }

        }
        System.out.println(count);
    }
}
