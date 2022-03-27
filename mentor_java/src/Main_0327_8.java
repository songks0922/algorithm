import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_0327_8 {

    static String solution(int face, int side, int apex) {
        String answer = "";
        if (face == 4 && side == 6 && apex == 4) {
            answer = "정사면체";
        } else if (face == 6 && side == 12 && apex == 8) {
            answer = "정육면체";
        } else if (face == 8 && side == 12 && apex == 6) {
            answer = "정팔면체";
        } else if (face == 12 && side == 30 && apex == 20) {
            answer = "정십이면체";
        } else if (face == 20 && side == 30 && apex == 12) {
            answer = "정이십면체";
        } else {
            answer = "False";
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int face = Integer.parseInt(st.nextToken());
        int side = Integer.parseInt(st.nextToken());
        int apex = Integer.parseInt(st.nextToken());
        System.out.println(solution(face, side, apex));

    }
}
