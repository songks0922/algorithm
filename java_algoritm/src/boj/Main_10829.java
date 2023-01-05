package boj;

import java.io.*;

public class Main_10829 {

    static String ans = "";
    static StringBuilder sb;
    static void convertBin(long n) {
        if (n == 0 || n == 1) {
            sb.append(n);
        } else {
            convertBin(n / 2);
            sb.append(n % 2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        long N;

        N = Long.parseLong(br.readLine());
        convertBin(N);
        System.out.println(sb);
    }
}