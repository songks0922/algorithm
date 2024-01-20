package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2875 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int i = 0; i <= K; i++) {
            for (int j = K - i; j <= K; j++) {
                int n = N - i;
                int m = M - j;
                count = Math.max(count, Math.min(n / 2, m));
            }
        }

        System.out.println(count);
    }
}
