package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2436 {

    public static long gcd(long a, long b) {
        while (a % b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long min = Long.MAX_VALUE;
        long x = 0;
        long y = 0;

        for (long i = A; i * i <= A * B; i += A) {

            for (long j = i; i * j <= A * B; j += A) {

                if (i * j == A * B && gcd(i, j) == A && i + j < min) {
                    min = Math.min(min, i + j);
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(x + " " + y + " ");
    }
}
