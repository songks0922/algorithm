package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String jehawn = br.readLine();
        String doctor = br.readLine();

        if (jehawn.length() < doctor.length()) {
            System.out.println("no");
            return;
        }

        System.out.println("go");
    }
}
