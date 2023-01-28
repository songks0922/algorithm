package inflearn.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch2_6 {

    private static String solution(int N, String input) {
        StringBuilder sb = new StringBuilder();
        int nums[] = init(N, input);
        reverse(nums, N);

        for (int i = 0; i < N; i++) {
            if (isPrime(nums[i])) {
                sb.append(nums[i]).append(" ");
            }
        }

        return sb.toString();
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int[] init(int N, String input) {
        int[] nums = new int[N+1];
        StringTokenizer st = new StringTokenizer(input);
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        return nums;
    }

    public static void reverse(int[] nums, int N) {
        for (int i = 0; i <= N; i++) {
            nums[i] = reverseHelper(nums[i]);
        }
    }

    public static int reverseHelper(int num) {
        int result = 0;
        while (num != 0) {
            int each = num % 10;
            result = 10 * result + each;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.print(solution(N, br.readLine()));
    }
}
