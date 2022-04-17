package asg5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3 {

    static String solution(String str, String target, String replace) {
        String answer = "";
        answer = str.replace(target, replace);
        return answer;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(solution("Hello Python", "Python", "Java"));

    }
}
