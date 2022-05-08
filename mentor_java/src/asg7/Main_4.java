package asg7;

import java.util.ArrayList;
import java.util.List;

public class Main_4 {

    static int[][] solution(int[] arr) {
        int[][] answer = new int[3][];
        int[] cnt = new int[3];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                cnt[0]++;
            } else if (arr[i] % 3 == 0) {
                cnt[1]++;
            } else {
                cnt[2]++;
            }
        }
        answer[0] = new int[cnt[0]];
        answer[1] = new int[cnt[1]];
        answer[2] = new int[cnt[2]];
        int two = 0, three = 0, other = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                answer[0][two++] = arr[i];
            } else if (arr[i] % 3 == 0) {
                answer[1][three++] = arr[i];
            } else {
                answer[2][other++] = arr[i];
            }
        }


        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {2, 4,5,7,10};
        int answer[][] = solution(arr);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
