package boj.all2000.p2500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2583 {

    static int visited[][];
    static int map[][];

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;

    static void dfs(int x, int y) {
        visited[x][y] = 1;
        answer++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                if (map[nx][ny] == 0 && visited[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    map[j][l] = 1;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && visited[i][j] == 0) {
                    answer = 0;
                    dfs(i, j);
                    ans.add(answer);
                }
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

}
