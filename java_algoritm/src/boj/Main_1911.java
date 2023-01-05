package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_1911 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N*2];
        for (int i = 0; i < N*2; i += 2) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i+1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        int pos = 0;
        for (int i = 0; i < N*2; i += 2) {
            if (arr[i] > pos) {
                pos = arr[i];
            }
            if (arr[i+1] >= pos) {
                while (arr[i+1] > pos) {
                    pos += L;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}