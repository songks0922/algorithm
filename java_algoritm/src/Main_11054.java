import java.io.*;
import java.util.StringTokenizer;

public class Main_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N+1];
        int[] DP = new int[N+1];
        int[] RDP = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            DP[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (origin[j] < origin[i] && DP[i] < DP[j] + 1) {
                    DP[i] = DP[j] + 1;
                }
            }
        }

        for (int i = N; i >= 1; i--) {
            RDP[i] = 1;
            for (int j = N; j >= i; j--) {
                if (origin[i] > origin[j] && RDP[j] + 1 > RDP[i]) {
                    RDP[i] = RDP[j] + 1;
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            ans = ans < DP[i] + RDP[i] - 1 ? DP[i] + RDP[i] - 1 : ans;
        }

        System.out.println(ans);
    }
}