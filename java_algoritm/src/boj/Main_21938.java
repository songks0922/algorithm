package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21938 {

    static int N, M, T;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (board[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

//    static void convert(int[][] board) {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j += 3) {
//                if (avg(board[i][j], board[i][j + 1], board[i][j + 2]) >= T) {
//                    convert255(board, i, j);
//                    continue;
//                }
//                convert0(board, i, j);
//            }
//        }
//    }
//
//    static void convert255(int[][] board, int row, int column) {
//        for (int i = 0; i < 3; i++) {
//            board[row][column + i] = 255;
//        }
//    }
//
//    static void convert0(int[][] board, int row, int column) {
//        for (int i = 0; i < 3; i++) {
//            board[row][column + i] = 0;
//        }
//    }


    static double avg(int... numbers) {
        int count = 0;
        double sum = 0;

        for (int num : numbers) {
            sum += num;
            count++;
        }

        return sum / count;
    }

    static void convert(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] >= T) {
                    board[i][j] = 255;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board[i][j] = (int) avg(r, g, b);

            }
        }
        T = Integer.parseInt(br.readLine());

        convert(board);

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M ; j++) {
                if (board[i][j] == 255 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
