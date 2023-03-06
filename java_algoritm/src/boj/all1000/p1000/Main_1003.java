package boj.all1000.p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003 {
    static final int MAX_NUMBER = 40;
    static int[] memo = new int[MAX_NUMBER + 1];

    private static void fibo() {

        for (int i = 2; i <= MAX_NUMBER; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        memo[0] = 0;
        memo[1] = 1;

        int T = Integer.parseInt(br.readLine());
        int num = 0;
        fibo();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j <= n; j++) {
                num = memo[j];


            }
        }

    }
}
