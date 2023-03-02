package boj.all1000.p1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389 {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int min = Integer.MAX_VALUE, minNode = 0, count = 0;

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            Iterator<Integer> iter = list.get(current).listIterator();

            while(iter.hasNext()) {
                int next = iter.next();
                if(!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.add(next);
                }
            }
        }
        System.out.println(count);
        saveMin(node, count);
    }

    static void saveMin(int node, int count) {
        if (count == min && minNode > node) {
            minNode = node;
            return;
        }

        min = Integer.min(min, count);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(list.get(i));
        }

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        System.out.println(minNode);
    }
}
