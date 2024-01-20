package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_6131 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 1; i <= 500; i++) {
            for (int j = i; j <= 500; j++) {
                if (Math.pow(j, 2) == (Math.pow(i, 2) + N)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
