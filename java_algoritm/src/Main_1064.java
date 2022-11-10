import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1064 {
    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Coordinate other) {
            return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Coordinate[] arr = new Coordinate[3];

        double[] distance = new double[3];
        
        while(st.hasMoreTokens()) {
            for (int i = 0; i < 3; i++) {
                arr[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < 3; i++) {
                distance[i] = arr[i].distance(arr[(i + 1) % 3]);
            }

            if ((arr[1].y - arr[0].y) * (arr[2].x - arr[1].x) == (arr[1].x - arr[0].x) * (arr[2].y - arr[1].y)) {
                System.out.println(-1.0);
            }
            else {
                double minVal = Double.MAX_VALUE;
                double maxVal = Double.MIN_VALUE;

                for (int i = 0; i < 3; i++) {
                    double sum = 0;
                    sum += distance[i];
                    sum += distance[(i + 1) % 3];
                    sum *= 2;

                    if (sum > maxVal)
                        maxVal = sum;
                    if (sum < minVal)
                        minVal = sum;
                }

                System.out.println(maxVal - minVal);
            }

        }

    }
}
