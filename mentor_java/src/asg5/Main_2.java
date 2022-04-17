package asg5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2 {

    static int[] solution(int n) {
        int[] answer = new int[n];

        for (int i= n; i > 0; i--) {
            answer[n-i] = i;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] answer = solution(n);

        System.out.print("[");
        for(int i = 0; i < answer.length; i++) {
            if(i == answer.length - 1) {
                System.out.print(answer[i]);
            } else {
                System.out.print(answer[i] + ",");
            }
        }
        System.out.println("]");

    }
}
