package asg6;

public class Main_2 {

    static int solution(int[] arr) {
        int answer = 0;
        int sum=0;

        for (int i=0;i<arr.length;i++){
            sum*=arr[i];
        }

        while (sum!=0){ //101이면 세면 안됨
            if(sum%10==0){
                answer++;
                sum/=10;
            }
            else if(sum%10!=0)
            {
                break;
            }

        }
        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {2,3,4,5,7,9,10};
        System.out.println(solution(arr));
    }
}
