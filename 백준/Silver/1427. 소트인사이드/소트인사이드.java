
import java.util.Scanner;

/**
 * 선택정렬 이용
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int size = str.length();
        int[] A = new int[size];
        //자리수별로 나누어 배열에 담기(substring() 사용)
        for (int i = 0; i < size; i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        //
        for (int i = 0; i < size; i++) {
            int max = i; // 최대값
            for (int j = i + 1; j < size; j++) {
                // swap할 값보다 한자리 뒤에서부터 max 값 찾기
                if (A[j] > A[max]) max = j;
            }
            if (A[i] < A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        // 출력
        for (int i = 0; i < size; i++) {
            System.out.print(A[i]);
        }
    }
}
