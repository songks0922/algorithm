package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1856_codeup {
    static int ans = 0;
    static void cade(int n) {
        if (n == 1) {
            ans++;
        } else if (n == 2) {
            ans++;
            cade(1);
        } else if (n == 3) {
            ans++;
            cade(1);
            cade(2);
        } else {
            cade(n - 1);
            cade(n-2);
            cade(n-3);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;

        N = Integer.parseInt(br.readLine());
        cade(N);
        System.out.println(ans);
    }
}