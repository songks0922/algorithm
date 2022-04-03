import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_0403_5 {
    static int solution(int n) {
        int answer = 0;
        while (n != 0) {
            if (answer < n%10) {
                answer = n%10;
            }
            n /= 10;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}
