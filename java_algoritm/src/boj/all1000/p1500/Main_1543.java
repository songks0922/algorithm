package boj.all1000.p1500;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1543 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String word = br.readLine();
        int cnt = 0;

        for (int i = 0; i < target.length() - word.length() + 1; i++) {
            if (target.substring(i, i+word.length()).equals(word)) {
                cnt++;
                i += word.length() - 1;
            }
        }
        System.out.println(cnt);
    }
}