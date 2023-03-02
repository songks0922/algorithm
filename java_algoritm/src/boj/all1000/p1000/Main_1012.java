package boj.all1000.p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1012 {

    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<List<Node>> list;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            visited = new boolean[m + 1][n + 1];

            for (int j = 0; j <= m; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < k; j++) {
//                list.get(m).add()
            }
        }
    }

}
