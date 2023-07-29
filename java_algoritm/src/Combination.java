import java.util.ArrayList;
import java.util.List;

public class Combination {

    static List<List<Integer>> memo = new ArrayList<>();

//    static void addCombination(int[] arr, boolean[] visited) {
//        List<Integer> combination = new ArrayList<>();
//
//        for (int i = 0; i < visited.length; i++) {
//            if (visited[i] == true) {
//                combination.add(arr[i]);
//            }
//        }
//        memo.add(combination);
//    }

    static void addCombination(int[] arr, boolean[] visited) {
        List<Integer> combination = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                combination.add(arr[i]);
            }
        }
        memo.add(combination);
    }

    static void comb(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            addCombination(arr, visited);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            comb(arr, visited, i + 1, r - 1);
            visited[i] = false;
        }
    }

//    static void comb(int[] arr, boolean[] visited, int start, int r) {
//        if (r == 0) {
//            addCombination(arr, visited);
//            return;
//        }
//
//        for (int i = start; i < arr.length; i++) {
//            visited[i] = true;
//            comb(arr, visited, i + 1, r - 1);
//            visited[i] = false;
//        }
//    }

    //1. 백트래킹을 이용해 구현
    static void comb1(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; //조합을 만들 배열
        boolean[] visited = new boolean[arr.length];

        //1. 백트래킹을 이용해 구현
        System.out.println("-------- 1. 백트래킹 ---------");

        for(int r = 1; r <= arr.length; r++) {
            comb(arr, visited, 0, r);
        }

        for (List<Integer> integers : memo) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

}
