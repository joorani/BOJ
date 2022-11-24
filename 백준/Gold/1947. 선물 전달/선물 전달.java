

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // N명일 떄 선물을 교환할 수 있는 경우의 수
        long[] D = new long[1000001];
        long mod = 1000000000;

        //점화식 도출
        // 선물 교환에는 두 가지 경우가 가능함
        //1. 단 방향으로 교환하는 경우 .D[n-1] 1명만 선물을 받았기 때문에 n-1
        //2. 양방향으로 교환하는 경우 D[n-2] 2명이 선물을 받았기 떄문에 n-2
        D[1] = 0;
        D[2] = 1;
        for (int i = 3; i <= n; i++) {
         //(i-1)을 곱하는 이유는 자기 자신이 아닌 n-1에게 선물을 할 수 있기 때문
            D[i] = (i-1) * (D[i-2] + D[i-1]) % mod;
        }

        //결과 출력
        System.out.println(D[n]);

    }
}
