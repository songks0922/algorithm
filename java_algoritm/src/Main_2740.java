import java.io.*;
import java.util.StringTokenizer;

public class Main_2740 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N, M, K;
        int[][] A, B, result;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[N][K];

        for (int n = 0; n < N; n++) {
            for (int k = 0; k < K; k++) {
                for (int m = 0; m < M; m++) {
                    result[n][k] += A[n][m] * B[m][k];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                bw.write(result[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

}