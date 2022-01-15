import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Stack<Integer> s = new Stack<>();
        int seq = 1;
        int[] students = new int[N];
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (students[i] != seq) {
                if (!s.isEmpty() && s.peek() == seq) {
                    s.pop();
                    i--;
                    seq++;
                } else {
                    s.push(students[i]);
                }
            } else {
                seq++;
            }
        }

        while (true) {
            if (!s.isEmpty() && seq == s.peek()) {
                s.pop();
                seq++;
            } else {
                break;
            }
        }

        if (s.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }

    }

}