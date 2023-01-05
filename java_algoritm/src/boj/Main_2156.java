package boj;

import java.io.*;

import static java.lang.Math.max;

public class Main_2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] DP = new int[n+2];
        int[] wine = new int[n+2];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        DP[0] = 0;
        DP[1] = wine[1];
        DP[2] = DP[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            DP[i] = max(max((DP[i-3] + wine[i-1] + wine[i]), DP[i-1]), DP[i-2] + wine[i]);
        }

        System.out.println(DP[n]);

    }
}