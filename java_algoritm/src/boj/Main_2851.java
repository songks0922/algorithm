package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2851 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int m = Integer.parseInt(br.readLine());
            if (sum + m >= 100 && 100 - sum < sum + m - 100) {
                break;
            }
            sum += m;
        }

        System.out.println(sum);
    }
}
