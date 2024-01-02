package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_5_3 {

    public static List<Integer> solve(List<Integer> num1, List<Integer> num2) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        boolean sign = isOpposite(num1.get(0), num2.get(0));

        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));


        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }
        }

        if (sign) {
            result.set(0, result.get(0) * -1);
        }
        int isZero;

        for (isZero = 0; result.get(isZero) == 0; isZero++) {}

        return result.subList(isZero, result.size());
    }

    private static boolean isOpposite(int num1, int num2) {
        boolean a = (num1 < 0 && num2 > 0);
        return (num1 < 0 && num2 > 0) || (num1 > 0 && num2 < 0);
    }

    public static void main(String[] args) {
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();

        num1.addAll(List.of(1, 2));
        num2.addAll(List.of(1, 4));

        List<Integer> solve = solve(num1, num2);

        for (Integer num : solve) {
            System.out.print(num + " ");
        }
    }
}
