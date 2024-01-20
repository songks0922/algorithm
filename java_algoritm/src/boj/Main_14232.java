package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_14232 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long k = Long.parseLong(br.readLine());
        long x = k;
        List<Long> list = new ArrayList<>();
        for (long i = 2; i < k + 1; i++) {
            if (i * i > k) {
                break;
            }

            while (x % i == 0) {
                list.add(i);
                x /= i;
            }
        }

        if (x != 1) {
            list.add(x);
        }

        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
                break;
            }
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
