package inflearn.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch2_10 {

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int solution(int[][] board, int n) {
        int answer = 0;
        boolean flag;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (board[i][j] <= board[nx][ny]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N+2][N+2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(board, N));
    }

}
