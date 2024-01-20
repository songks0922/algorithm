package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9417 {

    public static int gcd(int a, int b) {
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int max = 0;
            for (int j = 0; j < input.length - 1; j++) {
                for (int k = j + 1; k < input.length; k++) {
                    int gcd = gcd(Integer.parseInt(input[j]), Integer.parseInt(input[k]));
                    max = Math.max(max, gcd);
                }
            }
            System.out.println(max);
        }
    }
}
