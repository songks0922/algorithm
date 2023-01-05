package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String word = "";
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            word = br.readLine();

            if (check(word)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean check(String word) {
        int prev = 0;
        boolean[] alpha = new boolean[26];

        for (int j = 0; j < word.length(); j++) {
            int now = word.charAt(j);
            if (prev != now) {

                if (alpha[now - 'a'] == false) {
                    alpha[now - 'a'] = true;
                    prev = now;
                } else {
                    return false;
                }
            }
            continue;
        }
        return true;
    }
}
