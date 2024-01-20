package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2004 {

    public static long getNums(long n, long m) {
        long result = 0;

        while (n != 0) {
            n /= m;
            result += n;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long num1 = getNums(N, 2) - getNums(N - M, 2) - getNums(M, 2);
        long num2 = getNums(N, 5) - getNums(N - M, 5) - getNums(M, 5);

        System.out.println(Math.min(num1, num2));
    }
}
