import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2247 {

    public static long sod(long num) {
        long sum = 0;
        for (int i = 2; i < num; i++) {
            if (i * i > num) {
                break;
            }

            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long sum = 0;
        for (int i = 1; i < n + 1; i++) {
            long sod = sod(i);
            sum += sod;
        }

        System.out.println(sum);
    }
}
