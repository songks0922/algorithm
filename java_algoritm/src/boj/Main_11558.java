package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_11558 {

    static List<Integer>[] adjacentList;
    static int[] visited;
    static int N;

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : adjacentList[curr]) {
                if (visited[next] == 0) {
                    visited[next] = visited[curr] + 1;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            adjacentList = new ArrayList[N + 1];
            visited = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                adjacentList[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                int curr = Integer.parseInt(br.readLine());
                adjacentList[i].add(curr);
            }

            bfs(1);

            if (visited[N] == 0) {
                System.out.println(0);
                continue;
            }
            System.out.println(visited[N] - 1);
        }
    }
}
