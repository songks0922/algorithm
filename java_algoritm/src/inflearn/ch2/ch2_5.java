package inflearn.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch2_5 {

    private static int solution(int N) {
        int[] nums = init(N);

        for (int i = 2; i <= N; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j <= N; j += i) {
                nums[j] = 0;
            }
        }
        return count(nums, N);
//        return (int) Arrays.stream(nums).filter(num -> num != 0 && num <= N).count();
    }

    private static int count(int[] nums, int N) {
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (nums[i] != 0) {
                cnt++;
            }
        }
        return cnt;
    }


    private static int[] init(int N) {
        int[] nums = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            nums[i] = i;
        }
        return nums;
    }

    // 강의 풀이
    private static int solution2(int N) {
        int[] nums = new int[N + 1];
        int answer = 0;

        for (int i = 2; i <= N; i++) {
            if (nums[i] == 0) {
                answer++;
                for (int j = i; j <= N; j += i) {
                    nums[j] = 1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solution2(N));
    }
}
