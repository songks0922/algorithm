package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2476 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int three = Integer.parseInt(st.nextToken());
            int sum = 0;

            if (one == two && two == three)
                sum = 10000 + (one * 1000);
            else if (one == two || one == three)
                sum = 1000 + (one * 100);
            else if (two == three)
                sum = 1000 + (two * 100);
            else {
                int max = Math.max(one, Math.max(two, three));
                sum = max * 100;
            }
            ans = (ans < sum) ? sum : ans;
        }
        System.out.println(ans);
    }
}