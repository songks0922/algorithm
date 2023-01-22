package inflearn.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch2_1 {

    private static String solution(int N, String input) {
        StringTokenizer st = new StringTokenizer(input);
        StringBuilder answer = new StringBuilder();
        int pre = Integer.parseInt(st.nextToken());
        answer.append(pre).append(" ");

        for (int i = 0; i < N - 1; i++) {
            int curr = Integer.parseInt(st.nextToken());
            if (pre < curr) {
                answer.append(curr).append(" ");
            }
            pre = curr;
        }
        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        System.out.println(solution(N, input));
    }

}
