package boj.all1000.p1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());

        System.out.println(Solution(n));
    }
    static int Solution(long n) {
        long sum = 0;
        int addNum = 0;
        while(n >= sum) {
            sum += (++addNum);
        }

        return sum == n ? addNum : addNum - 1;
    }
}