import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_asg4_3 {

    static int solution(int n, int[] arr) {
        int cnt[] = new int[n];
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i]-1]++;
        }

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        String arrString = st.nextToken();
        st = new StringTokenizer(arrString, "[,]");
        int size = st.countTokens();
        int[] arr = new int[size];
        int index = 0;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            arr[index++] = num;
        }

        System.out.println(solution(n, arr));
    }
}
