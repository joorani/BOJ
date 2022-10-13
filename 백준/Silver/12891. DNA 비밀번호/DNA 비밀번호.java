
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int checkArr[]; // 비밀번호 체크 배열
    static int myArr[]; // 현재 상태 배열
    static int checkSecret; //4개 문자열 중에 몇 개 만족하는지 확인하는 용도의 변수(값이 4이면 모두 만족하는 유효한 비밀번호이다)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // s(문자열 크기), p(부분 문자열 크기) 입력받기
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int result = 0; // 결과값

        // A(문자열 데이터)
        char[] A = br.readLine().toCharArray();
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        
        // 부문 문자열에 포함되어야 할 A,C,G,T 개수 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            // 값이 0인 경우 비교할 필요가 없기 떄문에 미리 더해준다.
            if (checkArr[i] == 0) {
                checkSecret ++;
            }
        }

        // 처음 0부터 p개의 부분 문자열 처리
        for (int i = 0; i < p; i++) {
            add(A[i]);
        }

        //유효한 비밀번호인지 판단
        if(isValid(checkSecret)) result ++;

        // 슬라이딩 윈도우
        for (int i = p; i < s; i++) {
            int j = i-p; // 윈도우 첫 부분이 됨
            add(A[i]);
            remove(A[j]);

            //유효한 비밀번호인지 판단
            if(isValid(checkSecret)) result ++;
        }

        //결과값 출력
        System.out.println(result);
        br.close();
    }

    //유효한 비밀번호인지 판단하는 함수
    private static boolean isValid(int checkSecret) {
        return checkSecret == 4;
    }

    //삭제되는 문자를 처리하는 함수
    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    // 새로 들어운 문자를 처리하는 함수
    private static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }
}
