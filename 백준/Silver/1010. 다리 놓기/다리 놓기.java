
import java.util.Scanner;

public class Main {
    static long[][] D;
    static int t, n, m;
    public static void main(String[] args) {
        //배열 초기화하기
        D = new long[31][31];
        for (int i = 0; i < 31; i++) {
            D[i][0] = 1;
            D[i][i] = 1;
            D[i][1] = i;
        }
        // 점화식 이용해 배열 업데이트하기
        for (int i = 2; i < 31; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            m = sc.nextInt();

            System.out.println(D[m][n]);
        }
    }
}
