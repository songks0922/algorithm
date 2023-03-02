public class Spring1 {
    public static int solution(int[][] lotteries) {
        int answer = 1;
        int prize = lotteries[0][2];
        double percent;
        if (lotteries[0][0] > lotteries[0][1]) {
            percent = 100.0;
        } else {
            percent = (double) lotteries[0][0] / (lotteries[0][1] + 1);
        }

        for (int i = 1; i < lotteries.length; i++) {
            double curr;

            if (lotteries[i][0] > lotteries[i][1]) {
                curr = 100.0;
            } else {
                curr = (double) lotteries[i][0] / (lotteries[i][1] + 1);
            }
            if (percent < curr) {
                prize = lotteries[i][2];
                percent = curr;
                answer = i + 1;
                continue;
            }

            if (percent == curr && prize < lotteries[i][2]) {
                prize = lotteries[i][2];
                percent = curr;
                answer = i + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
//        int input[][] = {{50, 1, 50}, {100, 199, 100}, {1, 1, 500}};
        int input[][] = {{100, 100, 500}, {1000, 1000, 100}};

        System.out.println(solution(input));
    }

}
