package boj.all1000.p1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1325 {

    static int N, M;

    static List<Integer>[] adjacentList;
    static boolean[] visited;
    static int[] ans;
    static int count = 1, max = Integer.MIN_VALUE;

    static void dfs(int node) {
        visited[node] = true;
        for (int next : adjacentList[node]) {
            if (!visited[next]) {
                ans[next]++;
                dfs(next);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;

            for (int next : adjacentList[curr]) {
                if (!visited[next]) {
                    ans[next]++;
                    visited[next] = true;
                    queue.add(next);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjacentList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjacentList[from].add(to);
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
            Arrays.fill(visited, false);
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, ans[i]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++)
        {
            if (max == ans[i])
                sb.append(i + " ");
        }

        System.out.print(sb);

    }
}
