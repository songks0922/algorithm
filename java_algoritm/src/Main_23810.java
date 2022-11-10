import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_23810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        patternOne(N);
        patternTwo(N);
        patternOne(N);
        patternThree(N);
    }


    private static void patternOne(int N) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < 5 * N; k++) {
                System.out.print("@");
            }
            System.out.println();
        }
    }

    private static void patternTwo(int N) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N; k++) {
                System.out.print("@");
            }
            System.out.println();
        }
    }

    private static void patternThree(int N) {
        for (int j = 0; j < N * 2; j++) {
            for (int k = 0; k < N; k++) {
                System.out.print("@");
            }
            System.out.println();
        }
    }
}
