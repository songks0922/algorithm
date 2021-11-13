import java.io.*;
import java.util.StringTokenizer;

public class Main_1629 {

    static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A, B;
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));

    }

    static long pow(long A, long exp) {
        if (exp == 1) {
            return A % C;
        }

        long temp = pow(A, exp / 2);

        if (exp % 2 == 1) {
            return (temp * temp % C) * A % C;
        }

        return temp * temp % C;
    }
}