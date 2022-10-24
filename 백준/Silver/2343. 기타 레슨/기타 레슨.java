

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //이진탐색

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n(레슨 개수), m(블루레이 수)
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] data = new int[n];
        int start = 0;
        int end = 0;

        //데이터 입력받기, start, end 값 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            if (start < data[i]) start = data[i]; //시작값은 입력 데이터 최대값
            end += data[i]; // 종료값은 입력 데이터 총합
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int lessenSum = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (lessenSum + data[i] > mid) {
                    lessenSum = 0;
                    count++;
                }
                lessenSum += data[i];
            }
            if(lessenSum != 0) count++;
            if (count <= m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);


    }
}
