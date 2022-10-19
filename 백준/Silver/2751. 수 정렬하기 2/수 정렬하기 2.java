
import java.io.*;

public class Main {

    public static int[] A, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // A(정렬할 배열), tmp(정렬할 때 임시로 사용할 배열) 선언
        A = new int[N];
        tmp = new int[N];

        // 배열 값 입력받기
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N-1);
        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //병합 정렬 함수
    private static void mergeSort(int start, int end) {
        // 배열수가 2개 이상일 때만 수행
        if (end - start < 1) return;

        int mid = (start + end)/2;

        //재귀함수 형태로 구현
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        //tmp배열에 값 복사
        for (int i = start; i <= end; i++) {
            tmp[i]= A[i];
        }

        int part1 = start; //1번쨰 그룹 시작점
        int part2 = mid + 1; // 2번쨰 그룹 시작점

        int index = start;
        //merge
        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] < tmp[part2]) {
                A[index] = tmp[part1];
                part1++;
            } else {
                A[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        // 앞쪽 배열 남아있는 배열 처리(뒤쪽 배열은 그 값이 그대로 있기 떄문에 앞 배열만 처리해주면 된다.)
        while (part1 <= mid) {
            A[index] = tmp[part1];
            index++;
            part1++;
        }



    }
}
