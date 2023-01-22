package inflearn.ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch1_4 {

    private static String solution(String str) {
        char[] charList = str.toCharArray();
        reverseString(charList, 0, str.length()-1);
        return String.valueOf(charList);
    }

    private static void reverseString(char[] str, int start, int end) {
        if (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            reverseString(str, start + 1, end - 1);
        }
    }

    // 강의 풀이 1
    private static String solution2(String str) {
        String result = new StringBuilder(str).reverse().toString();
        return result;
    }

    // 강의 풀이 2
    private static String solution3(String str) {
        char[] charList = str.toCharArray();
        int lt = 0, rt = charList.length - 1;

        while (lt < rt) {
            char temp = charList[lt];
            charList[lt] = charList[rt];
            charList[rt] = temp;
            lt++;
            rt--;
        }
        return String.valueOf(charList);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            sb.append(solution3(str)).append("\n");
        }

        System.out.print(sb);
    }

}
