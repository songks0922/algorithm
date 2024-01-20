package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            for (long j = 2; j < 1000001; j++) {
                if (num % j == 0) {
                    System.out.println("NO");
                    break;
                }

                if (j == 1000000) {
                    System.out.println("YES");
                }
            }
        }
    }
}
