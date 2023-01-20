package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch1_7 {

    private static String solution(String str) {
        if (palindrome(str.toUpperCase(), 0, str.length() - 1)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean palindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // 강의 풀이 1
    private static String solution2(String str) {
        int len = str.length();
        str = str.toUpperCase();

        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return "NO";
            }
        }

        return "YES";
    }

    // 강의 풀이 2
    private static String solution3(String str) {

        String reverse = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(reverse)) return "YES";

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution3(str));
    }

}
