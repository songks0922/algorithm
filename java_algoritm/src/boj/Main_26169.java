package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_26169 {

    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int possible = 0;

    static void dfs(int x, int y, int depth, int count) {
        if (depth >= 3 && count >= 2) {
            possible = 1;
            return;
        }

        if (depth >= 3 && count < 2) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                if (!visited[nx][ny] && board[nx][ny] != -1) {
                    if (board[nx][ny] == 1) {
                        dfs(nx, ny, depth + 1, count + 1);
                    } else {
                        dfs(nx, ny, depth + 1, count);
                    }
                }
            }

        }

        visited[x][y] = false;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        dfs(x, y, 0, 0);
        System.out.println(possible);

    }

}
