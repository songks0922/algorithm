package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2863 {

    private static int solution(double A, double B, double C, double D) {
        int answer = 0;
        double max = Double.MIN_VALUE;
        double[] arr = new double[4];

        arr[0] = (A / C) + (B / D);
        arr[1] = (C / D) + (A / B);
        arr[2] = (D / B) + (C / A);
        arr[3] = (B / A) + (D / C);


        for(int i = 0; i < 4; i++) {
            if(max < arr[i]) {
                max = arr[i];
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());

        double C = Double.parseDouble(st.nextToken());
        double D = Double.parseDouble(st.nextToken());

        System.out.println(solution(A, B, C, D));
    }
}
