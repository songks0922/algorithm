import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_asg4_8 {

    static int solution(int[] arr) {
        int cnt[] = new int[10];
        int answer = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= max ) {
                if (max == cnt[i] && answer < i) {
                    answer = i;
                } else {
                    max = cnt[i];
                    answer = i;
                }
            }
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

        System.out.println(solution(arr));
    }
}
