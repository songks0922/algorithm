package inflearn.ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch1_10 {

    private static String solution(String input) {
        StringTokenizer st = new StringTokenizer(input);
        String str = st.nextToken();
        char target = st.nextToken().charAt(0);
        int[] answer = new int[101];
        int p = 1000;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != target) {
                p++;
                answer[i] = p;
            }
            if (str.charAt(i) == target) {
                p = 0;
                answer[i] = p;
            }
        }
        p = 1000;

        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) != target) {
                p++;
                answer[i] = Math.min(answer[i], p);
            }

            if (str.charAt(i) == target) {
                p = 0;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(answer[i]).append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        System.out.println(solution(input));
    }

}
