package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch1_8 {

    private static String solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String reverse = new StringBuilder(str).reverse().toString();

        if (str.equals(reverse)) return "YES";
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));
    }

}
