package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_1904 {

    static final int maxSize = 1000001;
    static Integer[] dp = new Integer[maxSize];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());



        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(Solve(N));

    }

    static int Solve(int N) {

        if (dp[N] == null) {
            dp[N] = (Solve(N-1) + Solve(N-2)) % 15746;
        }
        return dp[N];
    }


}