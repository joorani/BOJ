
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        //한자리 수가 소수인 2, 3, 5, 7 먼저 실행
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    private static void DFS(int num, int digit) {
        if (digit == n) {
            if (isPrime(num)) {
                System.out.println(num);
                return;
            }
        }

        //1~9까지
        for (int i = 1; i < 10; i++) {
            // 홀수인 경우만 DFS수행
            if (i % 2 == 0) continue;
            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, digit + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
