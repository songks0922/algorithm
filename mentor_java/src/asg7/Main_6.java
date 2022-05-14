package asg7;

public class Main_6 {
    public static int solution(int[][] votes) {
        int[] totalCnt = new int[5];
        int[] score = new int[5];

        for(int i=0; i<votes.length; i++) {
            int classCnt[] = new int[5];
            for(int j=0; j<votes[i].length; j++) {
                int vote = votes[i][j];
                totalCnt[vote]++;
                classCnt[vote]++;
            }
            System.out.print(classCnt[1]);
            System.out.print(classCnt[2]);
            System.out.print(classCnt[3]);
            System.out.println(classCnt[4]);
            System.out.println();
            // 각 반 별 표 집계
            int max_index = 1;
            for(int j=1; j<5; j++) {
                if(classCnt[j] > classCnt[max_index])
                    max_index = j;
            }
            score[max_index]++;
        }
        // socre가 제일 높은 후보 == 회장
        // 동점인 경우 totalCnt가 높은 후보가 회장
        int max_student = 1;
        for(int j=1; j<5; j++) {
            if(score[j] > score[max_student])
                max_student = j;
            else if(score[j] == score[max_student]) {
                if(totalCnt[j] > totalCnt[max_student])
                    max_student = j;
            }
        }
        return max_student;
    }

    public static void main(String[] args) {
        int[][] votes = {
                {1, 3, 3},
                {2, 3, 1, 3, 3},
                {1, 1, 1, 1}
        };

        System.out.println(solution(votes));
    }
}
