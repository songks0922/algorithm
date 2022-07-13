import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_asg3_4 {

    public static boolean is_prime(int number) {

        if(number < 2) {
            return false;
        }

        if(number == 2) {
            return true;
        }

        for(int i = 2; i <= Math.sqrt(number); i++) {

            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
    static int solution(int n) {

        int answer = 0;

        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            answer++;
            for (int i = 3; i <= n; i++) {

                for(int j = 2; j <= Math.sqrt(i); j++) {

                    if(i % j == 0) {
                        answer--;
                        break;
                    }
                }
                answer++;
            }
            return answer;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
}
