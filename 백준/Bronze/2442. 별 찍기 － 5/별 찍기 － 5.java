

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                bw.write(" ");
            }
            for (int j = 1; j <= 2*i-1 ; j++) {
                bw.write("*");
            }
            bw.write("\n"); // 개행
        }
        bw.flush();
        bw.close();
    }
}
