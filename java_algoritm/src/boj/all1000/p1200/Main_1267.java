package boj.all1000.p1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int y = 0;
        int m = 0;

        for (int i = 0; i < N; i++) {
            y += (nums[i] / 30 + 1) * 10;
            m += (nums[i] / 60 + 1) * 15;
        }

        if (y < m) {
            System.out.println("Y " + y);
        } else if (y > m) {
            System.out.println("M " + m);
        } else {
            System.out.println("Y M " + y);
        }
    }
}
