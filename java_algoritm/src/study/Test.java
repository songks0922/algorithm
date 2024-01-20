package study;

public class Test {

    public static int[] sort(int[] arr, int pivot) {
        int len = arr.length;

        int cnt = 0, startIdx = 0, lastIdx = len - 1;
        int[] temp = new int[len];

        for (int i = 0; i < len; i++) {
            if (arr[i] < pivot) {
                temp[startIdx++] = arr[i];
                continue;
            }

            if (arr[i] > pivot) {
                temp[lastIdx--] = arr[i];
                continue;
            }

            if (arr[i] == pivot) {
                cnt++;
            }
        }

        for (int i = startIdx; i < startIdx + cnt; i++) {
            temp[i] = pivot;
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 4, 3, 0, 2, 5, 1};
        int[] sorted = sort(arr, 2);

        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }
}
