import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_0403_3 {

    static int solution(int n) {
        int answer = 0;

        answer = n - (int)Math.sqrt(n);
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}
