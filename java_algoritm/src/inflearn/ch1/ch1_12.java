package inflearn.ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch1_12 {

    private static String solution(String str) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length() - 1; i += 7) {
            answer.append(convert(str.substring(i, i + 7)));
        }

        return answer.toString();
    }

    private static char convert(String str) {
        StringBuilder result = new StringBuilder();

        for (char x : str.toCharArray()) {
            if (x == '#') {
                result.append("1");
            }
            if (x == '*') {
                result.append("0");
            }
        }
        return (char) Integer.parseInt(result.toString(), 2);
    }

    private static String solution2(int n, String str) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String temp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(temp, 2);
            answer.append((char) num);
            str = str.substring(7);
        }
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        System.out.println(solution(br.readLine()));
        System.out.println(solution2(N, br.readLine()));
    }
}
