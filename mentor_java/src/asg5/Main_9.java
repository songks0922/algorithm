package asg5;

import java.io.IOException;

public class Main_9 {

    static int[] solution(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int result = 0;
            if (i % 2 == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        result++;
                    }
                }
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        result++;
                    }
                }
            }
            answer[i] = result;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        int[] answer;
        int[] nums = {
                1, 10, 2, 9, 3, 8, 4, 7, 5, 6
        };
        answer = solution(nums);
        System.out.print("[");
        for (int i = 0; i < answer.length; i++) {
            if (i == answer.length - 1) {
                System.out.print(answer[i]);
            } else {
                System.out.print(answer[i] + ",");
            }
        }
        System.out.print("]");

    }
}
