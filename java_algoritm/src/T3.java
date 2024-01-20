import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class T3 {

    static int solution(String[] kor, String[] usa, String[] incs) {
        int answer = -1;
        Map<String, List<String>> pairs = new LinkedHashMap<>();
        int size = 0;
        for (String k : kor) {
            List<String> pair = new ArrayList<>();
            for (String u : usa) {
                pair.add(u);
                size++;
            }
            pairs.put(k, pair);
        }

        int[] counts = new int[size];
        int index = 0;
        for (String target : incs) {
            List<String> check = Arrays.asList(target.split(" "));

            for (String key : pairs.keySet()) {
                for (String child : pairs.get(key)) {
                    if (check.contains(key) && check.contains(child)) {
                        counts[index]++;
                    }
                    index++;
                }
            }
            index = 0;

//            pairs.forEach((k, v) -> {
//                for (String child : v) {
//                    if (check.contains(k) && check.contains(child)) {
//                        counts[index]++;
//                    }
//                    index++;
//                }
//            });
//            for (int i = 0; i < pairs.size(); i++) {
//                if (check.containsAll(pairs.get(i))) {
//                    counts[i]++;
//                }
//            }
        }
        answer = Arrays.stream(counts).max().getAsInt();


        return answer;

    }
    public static void main(String[] args) {
        String[] kor = {"AAA", "BCD", "AAAAA", "ZY"};
        String[] usa = {"AB", "AA", "TTTT"};

        String[] incs = {
            "AB BCD AA AAA TTTT AAAAA",
            "BCD AAA",
            "AB AAA TTTT BCD",
            "AA AAAAA AB",
            "AAA AB BCD"
        };

//        String[] kor = {"CCC", "BCDF"};
//        String[] usa = {"XXXX"};
//
//        String[] incs = {
//            "BCDF CCC", "XXXX"
//        };

        System.out.println(solution(kor, usa, incs));
    }
}
