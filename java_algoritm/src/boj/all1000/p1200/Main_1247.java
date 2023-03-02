package boj.all1000.p1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_1247 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());

            BigInteger sum = new BigInteger("0");

            for (int j = 0; j < N; j++) {
                BigInteger num = new BigInteger(br.readLine());
                sum = sum.add(num);
            }

            if (sum.compareTo(BigInteger.ZERO) == -1) {
                answer.append("-").append("\n");
            }
            if (sum.compareTo(BigInteger.ZERO) == 1) {
                answer.append("+").append("\n");
            }
            if (sum.compareTo(BigInteger.ZERO) == 0) {
                answer.append("0").append("\n");
            }
        }

        System.out.print(answer);
    }
}
