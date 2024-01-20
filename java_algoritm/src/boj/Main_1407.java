package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int result = 0;

        for (long i = A; i <= B; i++) {
            result += Math.pow(2, count(i));
        }

        System.out.println(result);
    }

    private static long count(long i) {
        long result = 0;
        long x = i;

        for (long j = 2; j <= i; j++) {
            if (j * j > i) {
                break;
            }

            if (x % j == 0 && j == 2) {
                while (x % j == 0) {
                    result++;
                    x /= j;
                }
            }
        }
        return result;
    }
}
