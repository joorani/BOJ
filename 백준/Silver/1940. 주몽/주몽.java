

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 재료 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] material = new int[N];
        for (int i = 0; i < N; i++) {
            material[i] = Integer.parseInt(st.nextToken());
        }

        //재료들 정렬
        Arrays.sort(material);

        //투 포인터로 2수를 합쳐서 M이 되는 경우의 수 찾기
        int cnt = 0;
        int sum = 0;
        int startIdx = 0;
        int endIdx = N-1;

        while (startIdx < endIdx) {
            sum = material[startIdx] + material[endIdx];
            if (sum == M) {
                cnt ++;
                startIdx++;
                endIdx--;
            } else if (sum < M) {
                startIdx++;
            } else {
                endIdx--;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
