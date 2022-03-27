import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_0327_5 {

    static int solution(int n) {
        int answer = 0;
        int max = (int) Math.sqrt(n);
        for (int i = 2; i <= max; i++) {
            answer += i*i;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));

    }
}
