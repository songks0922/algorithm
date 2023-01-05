package boj;

import java.io.*;
import java.util.Stack;

public class Main_17608 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int h;
        for (int i = 0; i < N; i++) {
            h = Integer.parseInt(br.readLine());
            stack.push(h);
        }
        int pivot = stack.pop();
        int cnt = 1;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (pivot < curr) {
                cnt++;
                pivot = curr;
            }
        }
        System.out.println(cnt);
    }
}