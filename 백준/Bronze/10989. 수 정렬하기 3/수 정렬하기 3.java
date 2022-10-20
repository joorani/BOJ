
import java.io.*;

public class Main {
    /**
     * 기수정렬
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //A배열 저장하기
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        //최대값 구하기
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, A[i]);
        }
        radixSort(A, max);
        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void radixSort(int[] data,int max) {
        //최대값의 자리수만큼 반복(1, 10, 100..의 자리)
        for (int i = 1; (max / i) > 0; i *= 10) {
            countSort(data, i);
        }
    }

    //계수정렬
    private static void countSort(int[] data, int digit) {
        int n = data.length;
        int[] temp = new int[n]; // 정렬한 배열 담는 임시 배열
        int[] cnt = new int[10];
        
        for (int i = 0; i < n; i++) {
            cnt[(data[i]/digit)%10]++;
        }
        
        //cnt 값의 인덱스를 알아내기 위해 누적합
        for (int i = 1; i < 10; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int cntValue = (data[i]/digit) % 10;
            int newIdx = cnt[cntValue] -1;
            temp[newIdx] = data[i];
            cnt[cntValue]--;
        }

        //배열 복사
        for (int i = 0; i < n; i++) {
            data[i] = temp[i];
        }
    }
}
