package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10859 {

    public static String reverseString(String str) {
        return (new StringBuffer(str)).reverse().toString();
    }


    public static boolean isPrime(long num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Long num = Long.parseLong(input);

        if (!isPrime(num)) {
            System.out.println("no");

        } else {
            if (num == 1) {
                System.out.println("no");
                return;
            }

            if (input.indexOf('3') != -1 || input.indexOf('4') != -1 || input.indexOf('7') != -1) {
                System.out.println("no");
                return;
            }

            long reverse = Long.parseLong(reverseString(input));

            if (reverse == -1) {
                System.out.println("no");
                return;
            }

            if (isPrime(reverse)) {
                System.out.println("yes");
                return;
            }

            System.out.println("no");

        }
    }
}
