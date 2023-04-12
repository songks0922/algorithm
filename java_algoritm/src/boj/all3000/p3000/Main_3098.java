package boj.all3000.p3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3098 {

    static int N, M;
    static List<Integer>[] adjList;
    static boolean[][] visited;

    static boolean check() {
        for (int i = 1; i < adjList.length; i++) {
            if (adjList[i].size() < N - 1) {
                return true;
            }
        }
        return false;
    }

    static void marking() {
        for (int i = 1; i < adjList.length; i++) {
            for (int j = 0; j < adjList[i].size(); j++) {
                visited[i][adjList[i].get(j)] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer("");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int totalCount = 0, count;

        adjList = new ArrayList[N + 1];

        visited = new boolean[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);

            visited[from][to] = visited[to][from] = true;
        }

        while (check()) {
            totalCount++;
            count = 0;
            for (int i = 1; i <= N; i++) {
                int size = adjList[i].size();

                for (int j = 0; j < size; j++) {
                    int friend = adjList[i].get(j);

                    for (int neighbor : adjList[friend]) {
                        if (i != neighbor && !adjList[i].contains(neighbor) && visited[neighbor][friend]) {
                            adjList[i].add(neighbor);
                            count++;
                        }
                    }
                }
            }
            sb.append(count / 2).append("\n");
            marking();
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.println(totalCount + "\n" + sb);
    }

}
