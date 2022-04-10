import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_asg4_9 {

    static int[] solution(int[] arr) {
        int[] answer = new int[10];
        for (int i = 0; i < arr.length; i++) {
            answer[arr[i]]++;
        }

        return answer;
    }

    static String toString(int[] arr) {
        String answer = "";

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] + " ";
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");

        int size = st.countTokens();
        int[] arr = new int[size];
        int index = 0;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            arr[index++] = num;
        }

        System.out.println(toString(solution(arr)));
    }
}
