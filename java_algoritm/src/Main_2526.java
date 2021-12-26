import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2526 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int[] visited = new int[1001];
        int ans, num = N;
        int cnt = 1;
        visited[num] = cnt;
        while(true) {
            num = (num * N) % P;
            cnt++;
            if(visited[num] > 0) {
                ans = cnt - visited[num];
                break;
            }
            visited[num] = cnt;
        }
        System.out.println(ans);
    }
}