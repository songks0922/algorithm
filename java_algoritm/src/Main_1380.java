import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                return;
            }

            List<String> names = new ArrayList<>();
            List<Integer> check = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                names.add(br.readLine());
            }

            for (int i = 0; i < n * 2 - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int num = Integer.parseInt(st.nextToken());
                if (!check.contains(num)) {
                    check.add(num);
                } else {
                    check.remove((Integer)num);
                }
            }

            System.out.println(cnt + " " + names.get(check.get(0)-1));
            cnt++;
        }
    }
}
