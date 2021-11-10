import java.io.*;
import java.util.StringTokenizer;

public class Main_7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N, weight, height;
        N = Integer.parseInt(st.nextToken());
        int[][] person = new int [N][2];

        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(br.readLine(), " ");
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int rank = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (person[i][0] < person[j][0] && person[i][1] <person[j][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}