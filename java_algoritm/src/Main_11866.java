import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = init(N);

        String ans = solve(queue, K);
        System.out.println(ans);

    }

    static Queue<Integer> init(int N) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        return queue;
    }

    static String solve(Queue<Integer> queue, int K) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (queue.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll());
        sb.append(">");
        return sb.toString();
    }

}
