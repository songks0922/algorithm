import java.io.*;
import java.util.StringTokenizer;

public class Main_2960 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N, cnt = 0, K;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N+1];

        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j+=i) {
                if (!check[j]) {
                    cnt++;
                    check[j] = true;
                }

                if (cnt == K) {
                    bw.write(Integer.toString(j));
                    bw.flush();
                    bw.close();
                    br.close();
                    System.exit(0);
                }
            }
        }

    }

}