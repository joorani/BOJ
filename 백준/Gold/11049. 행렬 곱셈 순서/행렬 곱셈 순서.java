
import java.util.Scanner;

public class Main {
    static int n;
    static Matrix[] M;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        M = new Matrix[n+1];
        D = new int[n + 1][n + 1];

        //D배열 초기화
        for (int i = 0; i < D.length; i++) {
            for (int j = 0; j < D.length; j++) {
                D[i][j] = -1;
            }
        }
        //행렬 받기
        for (int i = 1; i <= n; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            M[i] = new Matrix(y, x);
        }

        System.out.println(execute(1, n));
    }

    // 탑 다운 방식으로 점화식 함수 구현하기
    private static int execute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (D[s][e] != -1) {
            //이미 계산했던 구간이면
            return D[s][e];
        }
        if (s == e) {
            //행렬 1개의 곱셈 연산의 수
            return 0;
        }
        if (s + 1 == e) {
            //행렬 2개의 곱셈 연산의 수
            return M[s].y * M[s].x * M[e].x;
        }
        //행렬 3개 일때
        for (int i = s; i < e; i++) {
            result = Math.min(result, M[s].y * M[i].x * M[e].x + execute(s, i) + execute(i + 1, e));
        }
        return D[s][e] = result;
    }

    //행렬 정보 저장 클래스
    static class Matrix {
        private int y;
        private int x;

        Matrix(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}

