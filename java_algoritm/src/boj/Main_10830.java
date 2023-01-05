package boj;

import java.io.*;
import java.util.StringTokenizer;

public class Main_10830 {


    static int N;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int result[][] = pow(A, B);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    static int[][] pow(int[][] matrix, long exp) {
        if (exp == 1L) {
            return matrix;
        }

        int[][] temp = pow(matrix, exp / 2);

        temp = multiply(temp, temp);

        if (exp % 2 == 1L) {
            temp = multiply(temp, A);
        }

        return temp;

    }

    static int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[N][N];

        for (int n = 0; n < N; n++) {
            for (int k = 0; k < N; k++) {
                for (int m = 0; m < N; m++) {
                    result[n][k] += A[n][m] * B[m][k];
                    result[n][k] %= 1000;
                }
            }
        }
        return result;
    }
}