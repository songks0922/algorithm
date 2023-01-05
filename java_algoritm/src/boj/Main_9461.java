package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main_9461 {

    static Long[] DP = new Long[101];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        DP[0] = 0L;
        DP[1] = 1L;
        DP[2] = 1L;
        DP[3] = 1L;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(Solution(N)).append('\n');
        }

        System.out.println(sb);

    }

    static long Solution(int N) {
        if (DP[N] == null) {
            DP[N] = Solution(N-2) + Solution(N-3);
        }
        return DP[N];
    }

}