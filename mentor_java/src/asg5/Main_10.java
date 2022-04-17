package asg5;

import java.io.IOException;
import java.util.*;

public class Main_10 {

    static int solution(int[] order) {
        int answer = 0;
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < order.length; i++) {
            numList.add(order[i]);
        }
        Set<Integer> numSet = new HashSet<>(numList);
        answer = numList.size() - numSet.size();
        return answer;
    }

    public static void main(String[] args) throws IOException {

        int[] order = {
                30, 50, 70, 50, 30
        };
        System.out.println(solution(order));
    }
}
