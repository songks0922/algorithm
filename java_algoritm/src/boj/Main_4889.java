package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int seq = 1;
        while (true) {

            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            if (s.contains("-")) break;
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);
                if (tmp == '{') {
                    stack.push(tmp);
                } else {
                    if (stack.isEmpty()) {
                        cnt++;
                        stack.push('{');
                    } else {
                        stack.pop();
                    }
                }
            }

            sb.append(seq++).append(". " + (cnt + stack.size() / 2));
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
