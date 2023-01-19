package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch1_2 {

    private static String solution(String str) {
        StringBuilder answer = new StringBuilder();
        int diff = 'a' - 'A';
        for (char c : str.toCharArray()) {
//            if (Character.isLowerCase(c)) {
//                answer.append(Character.toUpperCase(c));
//                continue;
//            }
//
//            if (Character.isUpperCase(c)) {
//                answer.append(Character.toLowerCase(c));
//            }
            // 아스키 코드 이용

            if (c >= 'a' && c <= 'z') {
                answer.append((char)(c - diff));
                continue;
            }
            answer.append((char)(c + diff));
        }

        return answer.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }
}
