package asg5;

import java.io.IOException;

public class Main_8 {

    static boolean solution(double[] vitamins) {
        boolean answer = true;
        double sum = 0;
        for (int i = 0; i < vitamins.length; i++) {
            sum += vitamins[i];
        }

        if (sum >= 200 && sum <= 500) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        double[] vitamins = {
                51.2,63.7,83.1, 29.3, 46.5
        };
        double[] vitamins1 = {
                17.3, 19.5, 22.3, 43.1
        };
        System.out.println(solution(vitamins1));

    }
}
