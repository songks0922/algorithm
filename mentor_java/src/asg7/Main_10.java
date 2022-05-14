package asg7;

public class Main_10 {
    public static int[] solution(int[] input) {
        int[] answer = new int[5];
        int a = 0;
        int count = 0;
        int count2 = 0;
        int count3 = 0;

        for(int i=0; i<input.length; i++) {
            if(input[i] % 2 != 0 && input[i] != 0) {
                count++;
            } else if(input[i] % 2 == 0 || input[i] == 0) {
                a = input[i];
                count3++;
                for(int j=count2; j<count; j++) {
                    if(input[j] > a) {
                        if(input[j] == 1) {
                            answer[0]++;
                        } else if(input[j] == 3) {
                            answer[1]++;
                        } else if(input[j] == 5) {
                            answer[2]++;
                        } else if(input[j] == 7) {
                            answer[3]++;
                        } else if(input[j] == 9) {
                            answer[4]++;
                        }
                    }
                }
                count2 = count + count3;
                count3 = 0;
                count += 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 5, 2, 5, 5, 7, 4, 1, 1, 3, 4};
        int[] answer = solution(input);

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}
