import java.io.*;
import java.util.Stack;

public class Main_9012 {

    static String solution(String s) {
        Stack<String> eachBrackets = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            String temp = s.substring(j,j+1);
            if (temp.equals("(")) {
                eachBrackets.add(temp);
            } else if (eachBrackets.empty()) {
                return "NO";
            } else {
                eachBrackets.pop();
            }
        }

        if (eachBrackets.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(solution(br.readLine())).append('\n');
        }

        System.out.println(sb);
    }

}