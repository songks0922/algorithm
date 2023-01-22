package inflearn.ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch1_5 {

    private static String solution(String str) {
        char[] list = str.toCharArray();

        return reverseString(list, 0, list.length - 1);
    }

    private static String reverseString(char[] str, int start, int end) {
        while (start < end) {
            if (Character.isAlphabetic(str[start]) && Character.isAlphabetic(str[end])) {
                char temp = str[start];
                str[start] = str[end];
                str[end] = temp;

                start++;
                end--;
                continue;
            }
            if (!Character.isAlphabetic(str[start])) {
                start++;
            }
            if (!Character.isAlphabetic(str[end])) {
                end--;
            }
        }

        return String.valueOf(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }


}
