package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14400 {

    static int[] arrX;
    static int[] arrY;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arrX = new int[N];
        arrY = new int[N];

        int x, y;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrX);
        Arrays.sort(arrY);

        x = arrX[N / 2];
        y = arrY[N / 2];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (Math.abs(arrX[i] - x) + Math.abs(arrY[i] - y));
        }


        System.out.println(sum);

    }

}
