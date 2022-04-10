import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_asg4_1 {

    static int solution(int[] arr) {
        int answer = 0, min = Integer.MAX_VALUE, max = arr[0];

        for (int i = 0; i < arr.length; i++) {  //[3, 10, 2, 1]
            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }
        answer = min * max;
        return answer;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int size = st.countTokens();
//        int[] arr = new int[size];
//        int index = 0;
//
//        while (st.hasMoreTokens()) {
//            int num = Integer.parseInt(st.nextToken());
//            arr[index++] = num;
//        }
//
//        System.out.println(solution(arr));
        String a = new String(" C#");
        String b = new String(",C++ ");
        System.out.println(a + "의 길이는 " + a.length());
        System.out.println(a.contains("#"));
        a = a.concat(b);
        System.out.println(a);
        a = a.trim();
        System.out.println(a);
        a = a.replace("C#","Java");
        System.out.println(a);
        String s[] = a.split(",");
        for (int i=0; i<s.length; i++) {
            System.out.println("분리된 문자열" + i + ": " + s[i]);
        }
        a = a.substring(5);
        System.out.println(a);
        char c = a.charAt(2);
        System.out.println(c);

    }
}
