package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2725 {

    public static int gcd(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());

        int[] memo = new int[1001];

        memo[1] = 3;

        for (int i = 2; i <= 1000; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (gcd(i, j) == 1) {
                    count++;
                }
            }
            memo[i] = memo[i - 1] + count * 2;
        }

        for (int i = 0; i < C; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(memo[N]);
        }

    }
}
