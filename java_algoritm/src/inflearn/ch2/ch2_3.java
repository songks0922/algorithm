package inflearn.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ch2_3 {

    private static String solution(int[] A, int[] B, int N) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (A[i] == B[i]) {
                answer.append("D").append("\n");
            }
            if (A[i] - B[i] == 1) {
                answer.append("A").append("\n");
            }
            if (A[i] - B[i] == -1) {
                answer.append("B").append("\n");
            }
            if (A[i] - B[i] == 2) {
                answer.append("B").append("\n");
            }
            if (A[i] - B[i] == -2) {
                answer.append("A").append("\n");
            }
        }

        return answer.toString();
    }

    private static int[] convert(String input) {
        String[] arr = input.split(" ");
        return Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = convert(br.readLine());
        int[] B = convert(br.readLine());

        System.out.print(solution(A, B, N));
    }
}
