package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode17 {

    static Map<String, String[]> phonNumber = new HashMap<>() {{
        put("1", new String[]{});
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};
    static List<String> answer = new ArrayList<>();

    static void solve(int index, String letter, String target) {
        if (index >= target.length()) {
            answer.add(letter);
            return;
        }

        String num = target.charAt(index) + "";

        for (String each : phonNumber.get(num)) {
            solve(index + 1, letter + each, target);
        }
    }

    public List<String> letterCombinations(String digits) {
        solve(0, "", digits);
        return answer;
    }

    public static void main(String[] args) {
        String digits = "2";

        solve(0, "", digits);
        System.out.println(answer.toString());
    }

}
