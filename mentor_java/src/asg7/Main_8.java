package asg7;

public class Main_8 {
    public static int day2index(int month, int day) {
        /* m월 d일은 1년의 몇 번째 날인지 계산 */
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int res = 0;
        for(int i=1; i<month; i++)
            res += days[i-1];
        return res + day;  //month+day
    }

    public static int solution(int[][] input1, int[][] input2) {
        int day1_first = day2index(input1[0][0], input1[0][1]);
        int day1_second = day2index(input1[1][0], input1[1][1]);

        int day2_first = day2index(input2[0][0], input2[0][1]);
        int day2_second = day2index(input2[1][0], input2[1][1]);

        int[] calendar = new int[366];

        if(day1_first < day1_second) {
            for(int i=day1_first; i<=day1_second; i++) {
                calendar[i]++;
            }
        }
        else {  // 날짜 순서 반대
            for(int i=day1_first; i<=365; i++) {
                calendar[i]++;
            }
            for(int i=1; i<=day1_second; i++) {
                calendar[i]++;
            }
        }
////////////////////////////////////////////////////////////
        if(day2_first < day2_second) {
            for(int i=day2_first; i<=day2_second; i++) {
                calendar[i]++;
            }
        }
        else {  // 날짜 순서 반대   #11,20 //11.19
            for(int i=day2_first; i<=365; i++) {
                calendar[i]++;
            }
            for(int i=1; i<=day2_second; i++) {
                calendar[i]++;
            }
        }

        int answer = 0;
        for(int i=1; i<=365; i++) {
            if(calendar[i] == 2)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] input1 = {
                {1, 3},
                {2, 20}
        };

        int[][] input2 = {
                {3, 5},
                {7, 30}
        };

        System.out.println(solution(input1, input2));
    }
}
