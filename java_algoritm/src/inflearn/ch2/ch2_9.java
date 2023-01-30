package inflearn.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch2_9 {

    private static int solution(int[][] board, int N) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for (int i = 0; i < N; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < N; j++) {
                sum1 += board[i][j];
                sum2 += board[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += board[i][i];
            sum2 += board[i][N - i - 1];
        }

        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(board, N));

    }
}
