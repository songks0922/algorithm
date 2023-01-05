package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main_1932 {

    static final int maxSize = 500;
    static int[][] dp = new int[maxSize][maxSize];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(Solve(N));

    }

    static int Solve(int N) {
        int ans = 0;
        if (N == 1) {
            return dp[0][0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][0] + dp[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j];
                } else {
                    dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j];
                }
                ans = max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}