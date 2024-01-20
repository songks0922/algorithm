package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16283 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int sheep = 0;
        int goat = 0;
        int flag = 0;

        int result1 = 0;
        int result2 = 0;

        for (sheep = 1; sheep < n; sheep++) {
            goat = n - sheep;

            if (a * sheep + b * goat == w) {
                flag++;
                result1 = sheep;
                result2 = goat;
            }
        }

        if (flag == 0 || flag > 1) {
            System.out.println("-1");
            return;
        }

        System.out.println(result1 + " " + result2);
    }
}
