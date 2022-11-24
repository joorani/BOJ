import java.util.Scanner;

public class Main {
    static int n, m, k;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        D = new int[202][202];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    D[i][j] = 1;
                } else {
                    D[i][j] = D[i - 1][j] + D[i - 1][j-1];
                    if (D[i][j] > 1000000000) D[i][j] = 1000000001; //k범위가 넘어가면 범위의 최대값 저장하기
                }
            }
        }
        if (D[n + m][m] < k) {
            System.out.println("-1");
        } else {
            while (!(n == 0 && m == 0)) {
                //a를 선택했을 때 남은 문자로 만들 수 있는 모든 경우의 수가 K보다 크면
                if (D[n - 1 + m][m] >= k) {
                    System.out.print("a");
                    n--;
                } else {
                    System.out.print("z");
                    k -= D[n - 1 + m][m];
                    m--;
                }
            }
        }
    }
}
