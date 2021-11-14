import java.io.*;

public class Main_2447 {

    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                printStar(i, j, N);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void printStar(int i, int j, int num) {
        if ((i / num)%3 == 1 && (j / num)%3 == 1) {
            sb.append(" ");
        }
        else
        {
            if(num / 3 == 0)
                sb.append("*");
            else
                printStar(i, j,num/3);
        }
    }
}