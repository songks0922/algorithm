package asg5;

public class Main_6 {

    static int solution(int[][] arr) {
        int answer = 0;
        int maxArear = 0;
        for (int i= 0; i < arr.length; i++) {
            int area = 0;
            area = arr[i][0] * arr[i][1];
            if (maxArear < area) {
                answer = i;
                maxArear = area;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {4,6},
                {7,4},
                {5,2}
        };
        System.out.println(solution(arr));
    }
}
