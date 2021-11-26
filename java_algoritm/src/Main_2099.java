import java.io.*;
import java.util.StringTokenizer;

public class Main_2099 {

    static class Matrix {
        private boolean[][] matrix;

        public Matrix(boolean[][] matrix) {
            this.matrix = matrix;
        }

        public boolean[][] getMatrix() {
            return matrix;
        }

        public Matrix multiply(Matrix m1) {
            int N = m1.getMatrix().length;

            Matrix temp = new Matrix(new boolean[N][N]);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if (this.getMatrix()[i][k] & m1.getMatrix()[k][j]) {
                            temp.getMatrix()[i][j] = true;
                        }
                    }
                }
            }

            return temp;
        }
    }

    static Matrix pow(Matrix m1, int M) {
        int N = m1.getMatrix().length;
        Matrix ans = new Matrix(new boolean[N][N]);

        for (int i = 0; i < N; i++) ans.getMatrix()[i][i] = true;

        while (M > 0){
            if (M % 2 == 1){
                ans = ans.multiply(m1);
            }
            m1 = m1.multiply(m1);
            M /= 2;
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] matrix = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[i][a-1] = true;
            matrix[i][b-1] = true;
        }

        Matrix m1 = new Matrix(matrix);

        Matrix ans = pow(m1, K);

        while (--M >= 0){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(ans.getMatrix()[a - 1][b - 1] ? "death" : "life").append('\n');
        }

        System.out.println(sb);
    }

}