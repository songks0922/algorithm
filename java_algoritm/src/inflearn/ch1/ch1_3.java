package inflearn.ch1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch1_3 {

    public static String solution(String str) {
        StringTokenizer st = new StringTokenizer(str);
        int max = 0;
        String answer = "";

        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (max < next.length()) {
                answer = next;
                max = next.length();
            }
        }

        return answer;
    }

    // 강의 풀이 1
    public static String solution2(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;

        String[] s = str.split(" ");

        for (String x : s) {
            int len = x.length();

            if (len > m) {
                m = len;
                answer = x;
            }
        }

        return answer;
    }

    // 강의 풀이 2 indexOf, substring 이용
    public static String solution3(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;

        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();

            if (len > m) {
                m = len;
                answer = tmp;
            }

            str = str.substring(pos + 1);

        }

        if (str.length() > m) answer = str;

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution3(str));

    }

}
