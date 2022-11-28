
import java.util.Scanner;

public class Main {
    static long mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] D = new long[n+1][11];
        //길이가 1일때 높이 h로 끝나는 계단 수의 모든 경우의 수는 1
        for (int i = 1; i <=9; i++) {
            D[1][i] = 1;
        }

        for (int i = 2; i <=n; i++) {
            D[i][0] = D[i-1][1];
            D[i][9] = D[i - 1][8];
            for (int j = 1; j <= 8; j++) {
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
            }
        }
        //출력
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + D[n][i]) % mod;
        }
        System.out.println(sum);
    }
}
