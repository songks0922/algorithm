package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue;

public class Main_9372 {

    private static List<Integer>[] list;
    private static boolean[] visited;
    private static int N, M, result;

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited[curr] = true;
            result++;

            for (int next : list[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());



        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list[from].add(to);
                list[to].add(from);
            }

            bfs(1);
            System.out.println(--result);

            result = 0;

        }


    }
}
