package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] dp = new int[21][21];

    static int R, C;

    static char[][] map;
    static boolean[][] visited;
    static List<Character> memory;
    static int answer = Integer.MIN_VALUE;

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;
        boolean flag = false;

        if (x == 0 && y == 0) {
            flag = true;
        }

        memory.add(map[x][y]);
        int cnt = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (!visited[nx][ny] && !memory.contains(map[nx][ny])) {
                        visited[nx][ny] = true;
                        memory.add(map[nx][ny]);
                        cnt++;
                        queue.add(new Node(nx, ny));

                        if (nx == 0 && ny == 0) {
                            flag = true;
                        }
                    }
                }
            }
        }

        if (flag == true) {
            answer = Math.max(answer, cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new char[R][C];

            memory = new ArrayList<>();
            answer = Integer.MIN_VALUE;
            visited = new boolean[R][C];

            for (int j = 0; j < R; j++) {
                String s = br.readLine();
                for (int k = 0; k < C; k++) {
                    map[j][k] = s.charAt(k);
                }
            }


            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (!visited[j][k]) {
                        bfs(j, k);
                        memory.clear();
                        visited = new boolean[R][C];
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
