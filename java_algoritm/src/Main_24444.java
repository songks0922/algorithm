import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dfa {

    static int[][] dfa;
    static void constructDfa(String pattern) {
        int patLength = pattern.length();
        dfa[pattern]
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String pattern = st.nextToken();
            String text = st.nextToken();

            dfa = new int[3][7];


        }
    }

}
