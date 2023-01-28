package inflearn.ch2;

import java.util.Scanner;

public class ch2_4 {

    static int[] memo = new int[50];

    private static int fibo(int n) {
        if (n <= 1) {
            memo[n] = n;
            return memo[n];
        }
        if (memo[n] != 0) {
            return memo[n];
        } else {
            return memo[n] = fibo(n - 2) + fibo(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        fibo(N);
        for (int i = 1; i <= N; i++) {
            System.out.print(memo[i] + " ");
        }
    }
}
