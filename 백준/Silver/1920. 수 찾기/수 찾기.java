

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n(데이터 개수), m(탐색할 숫자 개수)
        int n = sc.nextInt();
        int[] data = new int[n];

        //데이터 배열 값 입력받기
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        //이분탐색 이용하기 위해 데이터배열 정렬하기
        Arrays.sort(data);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            boolean find = false;
            int target = sc.nextInt();
            //이진탐색 시작
            int startIdx = 0;
            int endIdx = n-1;
            while (startIdx <= endIdx) {
                int midIdx = (startIdx+endIdx) /2;

                if (data[midIdx] > target) {
                    endIdx = midIdx-1;
                } else if (data[midIdx] < target) {
                    startIdx = midIdx + 1;
                } else {
                    //data[midIdx] == target경우
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
