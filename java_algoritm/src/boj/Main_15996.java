package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15996 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (n / a != 0) {
            n /= a;
            cnt += n;
        }

        System.out.println(cnt);
    }
}
