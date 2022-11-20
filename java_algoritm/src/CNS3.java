import java.util.*;

public class CNS3 {

    public static List<String> subString(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                list.add(str.substring(i, j));
            }
        }
        return list;
    }

    public static int solution(String reference, String track) {
        int answer = 1;
        List<String> list = subString(reference);
        Collections.sort(list, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o2.length() - o1.length();
        });

        int index = 0;
        List<String> answerList = new ArrayList<>();
        while (index < track.length()) {
            for (String s : list) {
                if (track.substring(index).startsWith(s)) {
                    answerList.add(s);
                    index += s.length();
                    break;
                }
            }
        }
        answer = answerList.stream().mapToInt(String::length).min().orElse(0);

        return answer;
    }
    public static void main(String[] args) {
//        String reference = "abc";
//        String track = "bcab";

        String reference = "vxrvip";
        String track = "xrviprvipvxrv";
        System.out.println(solution(reference, track));
    }
}
