package boj.all1000.p1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1303_dfs {

    private static int N, M, count = 1;
    private static char[][] board;
    private static boolean[][] visited;
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};


    private static void dfs(int x, int y, char target) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N & ny < M) {
                if (!visited[ny][nx] && target == board[ny][nx]) {
                    count++;
                    dfs(nx, ny, target);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        board = new char[M][N];
        visited = new boolean[M][N];

        char target;
        int blue = 0, white = 0;

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count = 1;
                    target = board[i][j];
                    dfs(j, i, target);
                    if (target == 'W') {
                        white += Math.pow(count, 2);
                    }
                    if (target == 'B') {
                        blue += Math.pow(count, 2);
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }
}
