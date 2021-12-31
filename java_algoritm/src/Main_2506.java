import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2506 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sequence = 0;
        int score = 0;
        for(int i = 0; i < N; i++) {
            int ans = Integer.parseInt(st.nextToken());
            if (ans == 1) {
                sequence++;
                score += sequence * 1;
            } else {
                sequence = 0;
            }
        }
        System.out.println(score);
    }
}