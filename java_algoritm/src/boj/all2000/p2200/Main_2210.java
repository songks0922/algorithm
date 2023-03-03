package boj.all2000.p2200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2210 {

    static char[][] board;
    static HashSet<String> memo = new HashSet<>();

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static StringBuffer sb;

    public static void dfs(int x, int y, int depth) {
        if (depth == 5) {
            memo.add(sb.toString());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                sb.append(board[nx][ny]);
                dfs(nx, ny, depth + 1);
                sb.deleteCharAt(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sb = new StringBuffer();
                sb.append(board[i][j]);
                dfs(i, j, 0);
            }
        }

        System.out.println(memo.size());

    }
}
