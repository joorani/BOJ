
import java.util.Scanner;

public class Main {
    static int[][] D;

    public static void main(String[] args) {

        //배열 초기화하기
        D = new int[15][15];
        for (int i = 0; i < 15; i++) {
            D[0][i] = i;
            D[i][1] = 1;
        }

        //점화식 이용해 갑 업데이트하기
        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j];
            }
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //테스트 케이스 수

        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();//층 수
            int n = sc.nextInt(); // 호실
            System.out.println(D[k][n]);
        }

    }
}
