package asg7;

public class Main_3 {
    public static int solution(int[][] field, int row, int col) {
        int answer = 0;
        if(field[row][col]==1){
            return -1;
        }class Solution {
            public int[][] solution(int[] arr) {
                int[][] answer = new int[3][];
                int[] cnt = new int[3];

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % 2 == 0) {
                        cnt[0]++;
                    } else if (arr[i] % 3 == 0) {
                        cnt[1]++;
                    } else {
                        cnt[2]++;
                    }
                }

                answer[0] = new int[cnt[0]];
                answer[1] = new int[cnt[1]];
                answer[2] = new int[cnt[2]];
                int two = 0, three = 0, other = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % 2 == 0) {
                        answer[0][two++] = arr[i]; //만약 2라고 치면 첫번째칸 첫번째에 2를 넣음
                    } else if (arr[i] % 3 == 0) {
                        answer[1][three++] = arr[i];
                    } else {
                        answer[2][other++] = arr[i];
                    }
                }
                return answer;
            }
        }
        for (int i=row-1;i<=row+1;i++){  //좌표값이 0일때 안하는 이유는 앞에 이프문에서 걸러졌기
            for(int j=col-1;j<=col+1;j++){
                if(i<0||field.length<=i||j<0||field[j].length<=j){
                    continue;
                }if(field[i][j]==1)
                    answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] field = {
                {0, 1, 1, 0},
                {1, 1, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        System.out.println(solution(field,0, 1));
    }
}
