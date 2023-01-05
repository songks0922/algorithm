package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N+1];
        int[] DP = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            DP[i] = 1;
            for (int j = 1; j <= N; j++) {
                if (origin[j] < origin[i] && DP[i] < DP[j] + 1) {
                    DP[i] = DP[j] + 1;
                }
            }
        }
        Arrays.sort(DP);
        System.out.println(DP[DP.length - 1]);
    }

}