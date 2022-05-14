package asg7;


public class Main_1 {
    public static double solution(int[][] scores) {
        double answer = 0;
        double grade[]= new double[scores.length];//각반 평균 저장할 배열
        double max=0;//가장 높은 반의 평균
        double whole=0;//전체점수.
        double wholeave=0;//전체평균
        int wholestudent=0;//전체학생수.

        for(int i=0; i<scores.length;i++){
            for(int j=0; j<scores[i].length;j++){
                grade[i]+=scores[i][j]; //각반 전체 점수 합계
                whole+=scores[i][j]; //전체 점수 합게
            }
        }

        //각반 평균 구하기
        for(int i=0; i<scores.length;i++){
            grade[i]=grade[i]/scores[i].length;
        }
        //각반 평균 중 가장 높은 평균 구하기
        for (int i=0; i<grade.length;i++){
            if(grade[i]>max){
                max=grade[i];
            }
        }


        //전체 평균 구하기
        for(int i=0; i<scores.length;i++){     //전체 학생수 구하기
            wholestudent+=scores[i].length;
        }
        wholeave=whole/wholestudent;

        answer=max-wholeave;

        return answer;
    }

    public static void main(String[] args) {
        int[][] score = {{90, 80, 86}, {30, 40, 60, 70}, {94, 100, 100}};

        System.out.println(solution(score));
    }

}
