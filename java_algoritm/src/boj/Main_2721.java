package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2721 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;

            for (int j = 1; j <= N; j++) {
                sum += j * (j + 1) * (j + 2) / 2;
            }

            System.out.println(sum);
        }
    }
}
