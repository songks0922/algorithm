package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_1743 {

    static int[][] arr;
    static boolean[][] visited;
    static int N, M, K;
    static int max;
    static int count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        max = 0;
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            String line = bufferedReader.readLine();
            StringTokenizer str = new StringTokenizer(line, " ");
            int a = Integer.parseInt(str.nextToken()) - 1;
            int b = Integer.parseInt(str.nextToken()) - 1;
            arr[a][b] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(max);
    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;
        count = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int now_x = now.x + dx[i];
                int now_y = now.y + dy[i];

                if (now_x >= 0 && now_x < N && now_y >= 0 && now_y < M) {
                    if (!visited[now_x][now_y] && arr[now_x][now_y] == 1) {
                        visited[now_x][now_y] = true;
                        count++;
                        queue.offer(new Node(now_x, now_y));
                    }
                }
            }
        }
        if (max < count) {
            max = count;
        }
    }
}