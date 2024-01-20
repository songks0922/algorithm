package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_23888 {

    public static long sum(long a, long d, long n, long l) {
        if (l != 1) {
            return (n * (2 * a + (n - 1) * d)) / 2 - (((l-1) * (2 * a + (l - 2) * d)) / 2);
        }

        return (n * (2 * a + (n - 1) * d)) / 2;
    }

    public static long gcd(long a, long b) {
        while (a % b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            long l = Integer.parseInt(st.nextToken());
            long r = Integer.parseInt(st.nextToken());

            if (flag == 1) {
                System.out.println(sum(a, d, r, l));

                continue;
            }
            List<Long> list = new ArrayList<>();
            for (long j = l; j <= r; j++) {
                list.add(a + d * (j - 1));
            }

            long max = list.get(0);

            for (int j = 0; j < list.size(); j++) {
                max = gcd(list.get(j), max);
            }

            System.out.println(max);

        }
    }
}
