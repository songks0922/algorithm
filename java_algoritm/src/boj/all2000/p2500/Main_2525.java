package boj.all2000.p2500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2525 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        hour += (minute + time) / 60;
        minute = (minute + time) % 60;
        if (hour > 23) {
            hour -= 24;
        }
        System.out.println(hour + " " + minute);

    }
}