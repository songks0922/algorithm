import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_0327_10 {
    /**
     * 0, 90, 180, 270, 360 : 좌표축
     * 1~89: 제1사분면
     * 91~179: 제2사분면
     * 181~269: 제3사분면
     * 271~359: 제4사분면
     */
    static String solution(int theta) {
        String answer = "";
        int pivot = theta % 360;
        if (theta % 90 == 0) {
            answer = "좌표축";
        } else if (pivot < 90) {
            answer = "제1사분면";
        }  else if (pivot < 180) {
            answer = "제2사분면";
        }  else if (pivot < 270) {
            answer = "제3사분면";
        }  else if (pivot < 360) {
            answer = "제4사분면";
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int theta = Integer.parseInt(br.readLine());
        System.out.println(solution(theta));

    }
}
