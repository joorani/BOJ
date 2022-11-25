
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] D =new long[n+1][2];
        D[1][0] = 0;
        D[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            D[i][1] = D[i-1][0];
            D[i][0] = D[i-1][0] + D[i-1][1];
        }
        System.out.println(D[n][0] + D[n][1]);

    }
}
