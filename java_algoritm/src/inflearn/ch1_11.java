package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch1_11 {

    private static String solution(String str) {
        StringBuilder answer = new StringBuilder();
        str += " ";
        int count = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i+1)) {
                if (count > 1) {
                    answer.append(str.charAt(i)).append(count);
                } else {
                    answer.append(str.charAt(i));
                }
                count = 1;
                continue;
            }
            count++;
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
