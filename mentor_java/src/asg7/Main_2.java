package asg7;

public class Main_2 {
    public static boolean solution(String[][] alphabets, String word) {
        for(int i=0; i<alphabets.length; i++) {
            for(int j=0; j<alphabets[i].length; j++) {
                if(alphabets[i][j].charAt(0) == word.charAt(0)) {
                    boolean up = true;
                    boolean down = true;
                    boolean left = true;
                    boolean right = true;

                    for(int k=1; k<word.length(); k++) {
                        // up
                        if(i-k < 0 || alphabets[i-k][j].charAt(0) != word.charAt(k)) {
                            up = false;

                        }
                        // down
                        if(i+k >= alphabets.length || alphabets[i+k][j].charAt(0)  != word.charAt(k)) {
                            down = false;
                        }
                        // left
                        if(j-k < 0 || alphabets[i][j-k].charAt(0)  != word.charAt(k)) {
                            left = false;
                        }
                        // right
                        if(j+k >= alphabets[i].length || alphabets[i][j+k].charAt(0)  != word.charAt(k)) {
                            right = false;
                        }
                    }
                    if(up || down || left || right)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] alphabets = {
                {"d", "c", "a", "t"},
                {"e", "m", "e", "j"},
                {"k", "l", "e", "h"},
                {"g", "i", "r", "r"},
                {"a", "c", "t", "k"}
        };
        // 인자로 찾을 단어 입력
        System.out.println(solution(alphabets, "cat"));
    }
}
