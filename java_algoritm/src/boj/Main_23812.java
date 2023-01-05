package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_23812 {

    public static void pattern1(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("@");
            }

            for (int j = 0; j < N * 3; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < N; j++) {
                System.out.print("@");
            }
            System.out.println();
        }
    }

    public static void pattern2(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 5; j++) {
                System.out.print("@");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        pattern1(N);
        pattern2(N);
        pattern1(N);
        pattern2(N);
        pattern1(N);

    }
}
