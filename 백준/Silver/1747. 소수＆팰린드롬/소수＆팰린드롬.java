
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[10000001];
        //배열 초기화
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        //에라토스테네스 체 수행
        for (int i = 2; i <= Math.sqrt(A.length) ; i++) {
            if (A[i] == 0) continue;
            //배수 값 소수에서 제외
            for (int j = i + i; j < A.length; j = j+i) {
                A[j] = 0;
            }
        }
        //n부터 소수 이면서 팰린드롬인지 확인하기
        int temp = n;
        while (true) {
            if (A[temp] != 0) {
                if (isPalendrome(A[temp])) {
                    System.out.println(A[temp]);
                    break;
                }
            }
            temp++;
        }
    }

    private static boolean isPalendrome(int target) {
        //소수를 char 배열 형태로 변환한 후 투포인터로 확인
        char[] chars = String.valueOf(target).toCharArray();
        int s = 0;
        int e = chars.length - 1;

        while (s < e) {
            if (chars[s] != chars[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
