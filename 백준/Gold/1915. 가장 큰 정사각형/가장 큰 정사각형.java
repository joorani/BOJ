
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] DP = new long[n][m];
        long max = 0;
        //2차원 배열 입력받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                DP[i][j] = Long.parseLong(String.valueOf(line.charAt(j)));
                if (DP[i][j] == 1 && i > 0 && j > 0) {
                    DP[i][j] = Math.min(DP[i][j - 1], Math.min(DP[i - 1][j - 1], DP[i - 1][j])) + 1;
                }
                if (max < DP[i][j]) {
                    max = DP[i][j];
                }
            }
        }
        System.out.println(max * max);
    }

}

