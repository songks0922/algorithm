package boj.all2000.p2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1;

        for (int i = 1; i < (N / 2) + 1; i++) {
            int sum = i;
            for (int j = i + 1; i < (N / 2) + 2; j++) {
                if (sum == N) {
                    answer++;
                    break;
                } else if (sum > N) {
                    break;
                }
                sum += j;
            }
        }

        System.out.println(answer);

    }
}
