import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Queue {
    private int MAX_SIZE = 10;
    private int[] queue;
    private int frontIndex = 0;
    private int backIndex = -1;

    Queue() {
    }

    Queue(int size){
        queue = new int[size];
    }

    public void push(int x) {
        queue[++backIndex] = x;
    }

    public int size() {
        return backIndex - frontIndex + 1;
    }

    public boolean isEmpty() {
        if (size()==0)
            return true;
        else
            return false;
    }

    public int pop() {
        if (isEmpty())
            return -1;
        else
            return queue[frontIndex++];
    }

    public int front() {
        if (isEmpty())
            return -1;
        else
            return queue[frontIndex];
    }

    public int back() {
        if (isEmpty())
            return -1;
        else
            return queue[backIndex];
    }
}
public class Main_10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch(command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.push(x);
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

}
