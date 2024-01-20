package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16970 {

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b , a % b);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int x1 = 0; x1 <= n; x1++) {
            for (int y1 = 0; y1 <= m; y1++) {
                for (int x2 = 0; x2 <= n; x2++) {
                    for (int y2 = 0; y2 <= m; y2++) {
                        if (gcd(Math.abs(x2 - x1), Math.abs(y2 - y1)) + 1 == k) {
                            count++;
                        }
                    }

                }
            }
        }

        System.out.println(count / 2);
    }
}
