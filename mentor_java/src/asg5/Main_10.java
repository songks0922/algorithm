package asg5;

import java.io.IOException;
import java.util.*;

public class Main_10 {

    static int solution(int[] order) {
        int answer = 0;
        boolean[] reserve = new boolean[1001];

        for (int i = 0; i < order.length; i++) {
            if (reserve[order[i]]) {
                answer++;
            } else {
                reserve[order[i]] = true;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        int[] order = {
                10, 20, 30, 20, 10
        };
        System.out.println(solution(order));
    }
}
