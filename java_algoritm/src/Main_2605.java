import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2605 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            list.add(i-Integer.parseInt(st.nextToken()), i);
        }
        for (int i = 1; i <= N; i++) {
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}