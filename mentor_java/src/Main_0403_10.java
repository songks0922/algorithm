import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_0403_10 {

    static int solution(int input) {
        int answer = 0;
        String strNum = Integer.toString(input); // 숫자의 자리수를 구하기 위해 문자열로 바꾸고
        int numLen = strNum.length(); // 자리수를 저장

        int A = (int) (Math.pow(10, numLen) - input);
        int B = (int) (input - Math.pow(10, numLen - 1));


        if (A >= B) {
            answer = A;
        } else {
            answer = B;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        System.out.println(solution(input));
    }
}
