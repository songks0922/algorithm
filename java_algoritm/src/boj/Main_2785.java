package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2785 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);
        int cnt = 0;
        while(arr.size() > 1) {
            arr.set(0, arr.get(0) - 1);
            arr.remove(arr.size()-1);
            if (arr.get(0) == 0) {
                arr.remove(0);
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}