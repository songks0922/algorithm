package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15904 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ucpc[index]) {
                index++;
            }

            if (index == 4) {
                System.out.println("I love UCPC");
                return;
            }
        }
        System.out.println("I hate UCPC");
    }

}