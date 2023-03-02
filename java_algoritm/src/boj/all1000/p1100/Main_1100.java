package boj.all1000.p1100;

import java.io.*;

public class Main_1100 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] Board = new char[8][8];
        String s = "";
        int ans = 0;

        for (int i = 0; i < 8; i++) {
            s = br.readLine();
            for (int j = 0; j < 8; j++) {
                Board[i][j] = s.charAt(j);
                if ( (i + j) % 2 == 0 && Board[i][j] == 'F') ans++;
            }
        }
        System.out.println(ans);
    }
}