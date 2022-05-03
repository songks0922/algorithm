package asg6;

public class Main_10 {

    static public int solution(int[] books) {
        int answer = 0; //7,4=11이니까 안됨
        int sum=0;
        for (int i=0;i<books.length;i++){
            sum+=books[i];
            if(sum>10){
                answer += 10 - (sum - books[i]);
                sum = books[i];
            }
        }
        if (sum != 10) {
            answer += 10 - sum;
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 3}; // 다른 결과 보려면 여기 배일 부분 수정하면 됨

        System.out.println(solution(arr));
    }

}
