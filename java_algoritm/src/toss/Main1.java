package toss;


public class Main1 {

    public int solution(String s, int N) {
        int answer = 0;

        int[] memo = new int[N + 1];

        memo[s.charAt(0) - '0']++;
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - '0';
            memo[curr]++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main1 main = new Main1();
        System.out.println(main.solution("1341232125", 2));
    }

}
