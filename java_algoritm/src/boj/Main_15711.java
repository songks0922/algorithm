package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15711 {

    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 2000001;
        isPrime = new boolean[k + 1];

        for (int i = 0; i < k + 1; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(k + 1); i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < k + 1; j += i) {
                isPrime[j] = false;
            }
        }

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long plus = A + B;
            List<Integer> list = new ArrayList<>();

            for (int i = 2; i < plus % k; i++) {
                if (isPrime[i]) {
                    list.add(i);
                }
            }

            int to = 0, from = list.size() - 1;

            while (to < from) {
                int sum = list.get(to) + list.get(from);
                if (list.get(to) + list.get(from) == plus) {
                    System.out.println("YES");
                    break;
                }

                if (sum > plus) {
                    from--;
                    continue;
                }

                if (sum < plus) {
                    to++;
                }
            }

            if (to >= from) {
                System.out.println("NO");
            }
        }
    }
}
