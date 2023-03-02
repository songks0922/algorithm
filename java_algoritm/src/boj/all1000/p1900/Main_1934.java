package boj.all1000.p1900;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1934 {
    static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;
        else return gcd(n2, n1 % n2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            sb.append(n1 * n2 / gcd(n1,n2)).append('\n');

        }

        System.out.println(sb);
    }

}