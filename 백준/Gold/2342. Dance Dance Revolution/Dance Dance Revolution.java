
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // dp[n][l][r] = n개 수열을 수행했고, 왼쪽이 l, 오른쪽이 r에 있을 때 최소 누적 힘
        int dp[][][] = new int[100001][5][5];

        // 한 발을 이동할 떄 드는 힘 미리 저장하기
        int mp[][] = {
                {0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}};

        int n = 0, s = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 100001; k++) {
                    dp[k][i][j] = 100001 * 4; //충분히 큰 수로 초기화
                }
            }
        }
        dp[0][0][0] = 0;
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            for (int i = 0; i < 5; i++) {
                if (n == i) {
                    continue; //두발이 같은 자리에 있을 수 없음
                }
                for (int j = 0; j < 5; j++) {
                    //오른발을 옮겨 현재 모습이 됐을 때 최소의 힘 저장하기
                    dp[s][i][n] = Math.min(dp[s - 1][i][j] + mp[j][n], dp[s][i][n]);
                }
            }

            for (int j = 0; j < 5; j++) {
                if (n == j) {
                    continue;
                }
                for (int i = 0; i < 5; i++) {
                    //왼발을 옮겨 현재 모습이 됐을 때 최소의 힘 저장하기
                    dp[s][n][j] = Math.min(dp[s - 1][i][j] + mp[i][n], dp[s][n][j]);
                }
            }
            s++;
        }
        s--;
        //최솟값 찾기
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, dp[s][i][j]);
            }

        }
        System.out.println(min);
    }
}

