package boj.all1000.p1200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main_1238 {
    static class Node implements Comparable<Node> {
        int end;
        int dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
        }
    }
    static final int INF = 987654321;
    static int N, X;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> arr, reverseArr;

        arr = new ArrayList<>();
        reverseArr = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
            reverseArr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, dist));
            reverseArr.get(end).add(new Node(start, dist));
        }

        int[] dist1 = dijkstra(arr);
        int[] dist2 = dijkstra(reverseArr);
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }
        System.out.println(ans);
    }

    public static int[] dijkstra(ArrayList<ArrayList<Node>> a) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        boolean[] visited = new boolean[N + 1];
        int[] dists = new int[N + 1];

        Arrays.fill(dists, INF);
        dists[X] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if(!visited[cur]) {
                visited[cur] = true;
                for (Node node : a.get(cur)) {
                    if (!visited[node.end] && dists[node.end] > dists[cur] + node.dist) {
                        dists[node.end] = dists[cur] + node.dist;
                        pq.add(new Node(node.end, dists[node.end]));
                    }
                }
            }
        }
        return dists;
    }
}