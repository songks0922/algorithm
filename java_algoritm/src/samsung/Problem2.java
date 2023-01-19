package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String number = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean flag = false;
            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < number.length(); j++) {
                int num = number.charAt(j) - '0';

                if (num >= y || flag) {
                    answer.append(y);
                    continue;
                }

                if (num >= x) {
                    answer.append(x);

                    if (num != x) {
                        flag = true;
                    }
                    continue;
                }


            }

            if (answer.toString().equals("") || answer.toString().equals("0")) {
                answer.setLength(0);
                answer.append(-1);
            }
            sb.append("#" + i + " " + answer + "\n");

        }
        System.out.print(sb);
    }
}
