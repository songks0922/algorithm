package inflearn.ch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ch2_8 {

    private static String solution(List<Integer> result) {
        StringBuilder answer = new StringBuilder();
        List<Integer> list = new ArrayList<>(result);
        Collections.copy(list, result);
        list.sort(Collections.reverseOrder());

        for (int score : result) {
            answer.append(list.indexOf(score) + 1).append(" ");
        }

        return answer.toString();
    }

    private static String solution2(List<Integer> result) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < result.size(); i++) {
            int count = 1;
            for (int j = 0; j < result.size(); j++) {
                if (result.get(i) < result.get(j)) {
                    count++;
                }
            }
            answer.append(count).append(" ");
        }

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            result.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(solution2(result));
    }
}
