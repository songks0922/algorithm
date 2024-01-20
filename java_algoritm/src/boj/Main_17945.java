package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17945 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> x = new ArrayList<>();

        for (int i = -1000; i <= 1000; i++) {
            int result = (int)Math.pow(i, 2) + 2 * a * i + b;

            if (result == 0) {
                x.add(i);
            }

            if (x.size() == 2) {
                break;
            }
        }

        Collections.sort(x);
        if (x.size() == 1) {
            System.out.println(x.get(0));
            return;
        }

        System.out.println(x.get(0) + " " + x.get(1));
    }
}
