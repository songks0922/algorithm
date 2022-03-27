import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_0327_7 {

    static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer += i;
            if (answer > n) {
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));

    }
}
