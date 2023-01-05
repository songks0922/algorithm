package boj;

import java.util.*;
import java.io.*;
import java.util.Queue;

class Main_24444{
    static ArrayList<Integer>[] adjacent;
    static int users;

    public static int addCnt(int[] visited) {
        int sum = 0;
        for(int e : visited) {
            //System.out.print(e+" ");
            sum+=e;
        }
        //System.out.println(sum);
        return sum;
    }
    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] visited = new int[users+1];
        boolean[] marked = new boolean[users+1];
        queue.add(start);
        marked[start] = true;
        while(!queue.isEmpty()) {
            int first = queue.poll();
            for(int e : adjacent[first]) {
                if(visited[e]==0 && !marked[e]) {
                    queue.offer(e);
                    marked[e] = true;

                    visited[e]=visited[first]+1;
                }
            }
        }

        return addCnt(visited);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split("\\s");
        users = Integer.parseInt(info[0]);
        int relations = Integer.parseInt(info[1]);
        adjacent = new ArrayList[users+1];

        for(int i=1; i<=users; i++) {
            adjacent[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<relations ; i++) {
            String[] arr = br.readLine().split("\\s");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            adjacent[a].add(b);
            adjacent[b].add(a);
        }

        int answer = 1000000;
        int answerUser = 0;
        for(int i=1 ; i<=users; i++) {
            int a = bfs(i);
            if(a<answer) {
                answer = a;
                answerUser = i;
            }
        }

        System.out.println(answerUser);
    }
}