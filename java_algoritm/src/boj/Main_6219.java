package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6219 {

    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[4000001];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < Math.sqrt(isPrime.length); i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = A; i <= B; i++) {
            if (isPrime[i]) {
                if (String.valueOf(i).contains(String.valueOf(D))) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
