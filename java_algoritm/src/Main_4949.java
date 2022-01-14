import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;

        while (true) {

            s = br.readLine();

            if (s.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.empty() || stack.peek() != '(') {
                        sb.append("no\n");
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.empty() || stack.peek() != '[') {
                        sb.append("no\n");
                        flag = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (flag) continue;

            if (stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);

    }

}