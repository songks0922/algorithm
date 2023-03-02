package boj.all2000.p2100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main_2109 {

    static boolean[] checked;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int maxDay = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            maxDay = Math.max(day, maxDay);
            pq.add(new Node(pay, day));
        }
        checked = new boolean[maxDay+1];
        int sum = 0;
        while(!pq.isEmpty()) {
            Node lecture = pq.poll();
            for(int i = lecture.day; i >= 1; i--) {
                if(!checked[i]) {
                    checked[i] = true;
                    sum += lecture.pay;
                    break;
                }
            }
        }
        System.out.println(sum);

    }

    static class Node implements Comparable<Node> {
        int pay;
        int day;

        public Node(int price, int day) {
            this.pay = price;
            this.day = day;
        }

        @Override
        public int compareTo(Node node) {
            if(node.pay > this.pay) {
                return 1;
            } else if(node.pay == this.pay) {
                if(node.day < this.day) {
                    return 1;
                }
            }
            return -1;
        }

    }

}