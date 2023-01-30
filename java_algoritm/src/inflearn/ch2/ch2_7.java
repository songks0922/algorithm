package inflearn.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch2_7 {

    private static int solution(int N, int[] result) {
        int score = 0, count = 0;

        for (int i = 0; i < N; i++) {
            if (result[i] == 1) {
                count++;
                score += count;
            }
            if (result[i] == 0) {
                count = 0;
            }
        }

        return score;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, result));
    }
}
