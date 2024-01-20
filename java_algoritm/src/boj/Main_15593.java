package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15593 {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] checks = new int[1010];
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodes.add(new Node(x, y - 1));
        }


        for (int i = 0; i < N; i++) {
            int each = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                for (int k = nodes.get(j).x; k <= nodes.get(j).y; k++) {
                    if (checks[k] == 0) {
                        checks[k] = 1;
                        each++;
                    }
                }
            }
            max = Math.max(max, each);
            Arrays.fill(checks, 0);
        }

        System.out.println(max);
    }
}
