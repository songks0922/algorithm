package boj.all1000.p1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260 {

    static int N, M;
    static List<Integer>[] adjacentList;
    static boolean[] visited;

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int next : adjacentList[curr]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");
        for (int next : adjacentList[V]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adjacentList = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjacentList[from].add(to);
            adjacentList[to].add(from);
        }

        for (int i = 1; i < adjacentList.length; i++) {
            Collections.sort(adjacentList[i]);
        }

        dfs(V);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(V);


    }
}
