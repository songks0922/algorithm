import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2576 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 100;
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num % 2 == 1) {
                sum += num;
                min = min > num ? num : min;
            }
        }
        if(sum >0) {
            System.out.println(sum);
        }
        System.out.println((min == 100 ? -1 : min));

    }
}