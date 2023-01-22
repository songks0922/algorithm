package inflearn.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch2_2 {

    private static int solution(int N, int[] nums) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (max < nums[i]) {
                answer++;
                max = nums[i];
            }
        }

        return answer;
    }

    private static int[] init(String input, int N) {
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(input);

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        return nums;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        int[] nums = init(input, N);
        System.out.println(solution(N, nums));
    }
}
