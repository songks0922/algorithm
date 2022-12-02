import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2667 {

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static List<Integer> answer = new ArrayList<>();
    static int[][] map;
    static boolean[][] visited;
    static int n;

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void dfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));
        visited[y][x] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && ny < n && nx < n) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        queue.add(new Node(ny, nx));
                        visited[ny][nx] = true;
                        count++;
                    }
                }
            }
        }
        if (count != 0) {
            answer.add(count);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        int totalCount = 0;

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    totalCount++;
                }
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();

        sb.append(totalCount);
        answer.stream().forEach(count -> sb.append('\n').append(count));

        System.out.print(sb);
    }
}
