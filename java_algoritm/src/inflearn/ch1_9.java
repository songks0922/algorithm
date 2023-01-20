package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch1_9 {

    private static int solution(String str) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                answer.append(str.charAt(i));
            }
        }
        return Integer.parseInt(answer.toString());
    }

    // 강의 풀이 1
    private static int solution2(String str) {
        int answer = 0;

        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) answer = answer * 10 + (x - 48);
        }
        return answer;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution2(str));
    }
}
