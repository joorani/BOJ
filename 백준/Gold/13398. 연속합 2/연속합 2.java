
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        //수열 저장 배열
        int[] data = new int[n];
        long[] left = new long[n];

        //수열 데이터 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        left[0] = data[0];
        //왼쪽에서 오른쪽 방향 연속합 배열
        long result = left[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1]+ data[i], data[i]);
            result = Math.max(result, left[i]); //1개도 제거하지 않았을 떄 기본 최댓값 저장하기
        }

        //오른쪽에서 왼쪽 방향으로 index 포함한 최대 연속합
        long[] right = new long[n];
        right[n-1] = data[n-1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1] + data[i], data[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, left[i - 1] + right[i + 1]);
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
