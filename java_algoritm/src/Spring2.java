import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Spring2 {

    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

    static char[][] map;
    static boolean[][] visited;
    static int w, h;
    static int count = 0;

    static class Node {

        int x;
        int y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(y, x));
        visited[y][x] = true;
        count++;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                    if (!visited[ny][nx] && map[ny][nx] == '#') {
                        visited[ny][nx] = true;
                        count++;
                        queue.add(new Node(ny, nx));
                    }
                }
            }
        }
    }

    static void outer(int y, int x) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(y, x));
        visited[y][x] = true;
        count++;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                    if (!visited[ny][nx] && map[ny][nx] == '#') {
                        visited[ny][nx] = true;
                        count++;
                        queue.add(new Node(ny, nx));
                    }
                }
            }
        }
    }

    public static int solution(String[] grid) {
        int answer = 0;
        w = grid[0].length();
        h = grid.length;

        map = new char[h][w];
        visited = new boolean[h][w];
        int height = 0;
        for (String str : grid) {
            for (int i = 0; i < str.length(); i++) {
                map[height][i] = str.charAt(i);
            }
            height++;
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == '#') {
                    bfs(i, j);
                }
            }
        }
        answer += count;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        String input[] = {".....####", "..#...###", ".#.##..##", "..#..#...", "..#...#..", "...###..."};
        solution(input);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        //26
    }
}
