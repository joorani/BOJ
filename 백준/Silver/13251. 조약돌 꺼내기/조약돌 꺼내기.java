
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int m, k;
        int D[] = new int[51]; // 색깔별 조약돌 개수 저장 배열
        double[] probability = new double[51]; //확률 저장 배열
        double answer = 0.0; // 출력할 결과 변수(확률의 합)

        int totalStones = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        // 색깔별 조약돌 개수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            D[i] = Integer.parseInt(st.nextToken());
            totalStones += D[i];
        }

        k = Integer.parseInt(br.readLine()); // 뽑을 개수
        // 확률 배열 업데이트하기
        // 만약 선택할 조약돌 개수가 색깔별 조약돌 개수 보다 큰 경우 확률은 0이 된다.
        for (int i = 0; i < m; i++) {
            if (D[i] >= k) {
                probability[i] = 1.0; //초기화
                for (int j = 0; j < k; j++) {
                    probability[i] *= (double) (D[i] - j) / (totalStones - j);
                }
            }
            answer += probability[i];
        }

        System.out.println(answer);
    }


}

