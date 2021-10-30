//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws IOException {
//        long n = Long.parseLong(br.readLine());
//
//        System.out.println(Solution(n));
//    }
//    static int Solution(long n) {
//        int sum = 0;
//        int nums = 0;
//
//        while (n >= sum) {
//            sum += (++nums);
//        }
//        return sum == n ? nums : nums - 1;
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());

        System.out.println(Solution(n));
    }
    static int Solution(long n) {
        long sum = 0;
        int addNum = 0;
        while(n >= sum) {
            sum += (++addNum);
        }

        return sum == n ? addNum : addNum - 1;
    }
}