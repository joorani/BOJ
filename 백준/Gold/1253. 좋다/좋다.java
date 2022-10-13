

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 배열로 받기
        long[] nums = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 정렬
        Arrays.sort(nums);

        int result = 0;
        // 배열 돌면서 확인
        for (int k = 0; k < N; k++) {
            long find = nums[k]; // 찾고자 하는 값
            // 포인터 선언
            int s = 0;
            int e = N -1;

            while (s < e) {
                if (nums[s] + nums[e] == find) {
                    // find는 서로 다른 두 수의 합이어야 함을 체크
                    if (s != k && e != k) {
                        result ++;
                        break;
                    } else if (s == k) {
                        s++;
                    } else {
                        e --;
                    }
                } else if (nums[s] + nums[e] < find) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}
