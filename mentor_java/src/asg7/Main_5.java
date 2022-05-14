package asg7;

public class Main_5 {

    public static int[][] solution(int[][] input) {
        int max_row = 0;
        int max_col = 0;
        int min_row = 0;
        int min_col = 0;

        for(int i=0; i<input.length; i++) {
            for(int j=0; j<input[i].length; j++) {
                if(input[i][j] > input[max_row][max_col]) {
                    max_row = i;
                    max_col = j;
                }
                if(input[i][j] < input[min_row][min_col]) {
                    min_row = i;
                    min_col = j;
                }
            }
        }
        // swap //만약 최댓값이10 최솟값이 1인 상태에서 22번쨰 없으면
        //maxrow=1 이 되고 minrow도 1이 됨 따라서 교환이 안됨 따라서 최댓값 저장해야 함
        int tmp = input[max_row][max_col];  //최댓값좌표저장해둠, 아니면 최솟값만 두개가 됨
        input[max_row][max_col] = input[min_row][min_col];//그 저장배열을 바꾸고, 최댓값 좌표에 최솟값좌표
        input[min_row][min_col] = tmp;//최솟값좌표에 저장해두었떤 최댓값좌표 집어넣어
        return input;
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
