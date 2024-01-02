package study;

import java.util.ArrayList;
import java.util.List;

public class Problem_5_2 {

    public static void solve(List<Integer> arr) {
        int index = arr.size() - 1;
        int upper = 0;

        increase(arr, index);

        for (int i = index; i > 0; i--) {

            if (upper == 1) {
                increase(arr, i);
                upper = 0;
            }

            if (arr.get(i) == 10) {
                arr.set(i, 0);
                upper = 1;
            }
        }

        if (upper == 1) {
            increase(arr, 0);
        }
        if (arr.get(0) == 10) {
            arr.set(0, 1);
            arr.add(0);
        }
    }

    private static void increase(List<Integer> arr, int i) {
        arr.set(i, arr.get(i) + 1);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(9);
        arr.add(7);
        solve(arr);

        for (Integer number : arr) {
            System.out.print(number + " ");
        }
    }
}
