import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_25644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int max = -1;
        int answer = 0;

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) > max) max = arr.get(i);
            answer = Math.max(answer, max - arr.get(i));
        }

        System.out.println(answer);

    }
}
