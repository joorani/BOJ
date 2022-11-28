
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //수열 저장 배열, 연속합 저장 배열
        int[] data = new int[n];
        long[] D = new long[n];

        //수열 데이터 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        D[0] = data[0];
        long answer = D[0];
        for (int i = 1; i < n; i++) {
            D[i] = Math.max(D[i-1]+data[i], data[i]);
            answer = Math.max(D[i], answer);
        }
        System.out.println(answer);


    }
}
