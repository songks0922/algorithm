package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1145 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(min, num);
            list.add(num);
        }

        for (int i = 1; i < 1000000; i++) {
            int count = 0;
            for (Integer number : list) {
                if (i % number == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                System.out.println(i);
                break;
            }
        }
    }
}
