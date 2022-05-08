package asg7;

public class Main_5 {

    static int[][] solution(int[][] arr) {
        int[][] answer = new int[arr.length][];

        int max = arr[0][0];
        int min = arr[0][0];
        int minX = 0, minY = 0, maxX = 0, maxY = 0;
        for (int i = 0; i < arr.length; i++) {
            answer[i] = new int[arr[i].length];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[i][j] = arr[i][j];
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    maxX = i;
                    maxY = j;
                }
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    minX = i;
                    minY = j;
                }
            }
        }

        int temp = arr[maxX][maxY];
        answer[maxX][maxY] = answer[minX][minY];
        answer[minX][minY] = temp;


        return answer;
    }

    public static void main(String[] args) {

        int[][] arr = {{5,3,6}, {-2,4}, {9,4,1}};
        int answer[][] = solution(arr);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
