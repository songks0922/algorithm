package asg7;

public class Main_7 {
    public static int[][] solution(int[][] A, int[][] B) {
        int[][] error = new int[1][1];
        error[0][0] = -1;

        if(A[0].length != B.length) return error; //1,2,1   1,-1,2

        int[][] answer = new int[A.length][B[0].length]; //a세로, b가로
        for(int i=0; i<A.length; i++)
            for(int j=0; j<B[0].length; j++)
                for(int k=0; k<B.length/* or A[0].length*/; k++)
                    answer[i][j] += A[i][k] * B[k][j];

        return answer;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 1},
                {2, 0, 1},
                {-1, 0, 1}
        };

        int[][] B = {
                {1, 0},
                {-1, 1},
                {2, 3}
        };
        int answer[][] = solution(A, B);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
