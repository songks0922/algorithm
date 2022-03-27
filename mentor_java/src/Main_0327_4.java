import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_0327_4 {

    static String solution(int month, int day) {
        String answer = "";
        int totalDay = 0;

        for(int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    totalDay += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    totalDay += 30;
                    break;
                case 2:
                    totalDay += 28;
                    break;
            }
        }
        totalDay += day;

        int dayToInt = totalDay % 7; // 일주일이 7일이므로
        if (dayToInt == 0) {
            answer = "SUN";
        } else if (dayToInt == 1) {
            answer = "MON";
        } else if (dayToInt == 2) {
            answer = "TUE";
        } else if (dayToInt == 3) {
            answer = "WED";
        } else if (dayToInt == 4) {
            answer = "THU";
        } else if (dayToInt == 5) {
            answer = "FRI";
        } else if (dayToInt == 6) {
            answer = "SAT";
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        System.out.println(solution(month, day));

    }
}
