import java.util.Scanner;

public class Main {
    static int[][] D;
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        D = new int[n+1][n+1];
        //배열 초기화하기
        for (int i = 0; i <= n; i++) {
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }
        //출력하기
        System.out.println(D[n][k]);
    }
}
