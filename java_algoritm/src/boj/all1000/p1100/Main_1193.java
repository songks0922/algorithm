package boj.all1000.p1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int count = 1, prevCountSum = 0;
        while (true) {
            if (X <= prevCountSum + count) {

                if (count % 2 == 1) {
                    System.out.println((count - (X - prevCountSum - 1)) + "/" + (X - prevCountSum));
                    break;
                }
                System.out.println((X - prevCountSum) + "/" + (count - (X - prevCountSum - 1)));
                break;
            }
            prevCountSum += count;
            count++;
        }
    }
}
