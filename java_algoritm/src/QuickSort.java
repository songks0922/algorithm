public class QuickSort {

    static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int pivot = partition(arr, lo, hi);

        quickSort(arr, lo, pivot - 1);
        quickSort(arr, pivot + 1, hi);
    }

    static int partition(int[] arr, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = arr[hi];

        while (lo < hi) {

            while (arr[lo] < pivot && lo < hi) {
                lo++;
            }

            while (arr[hi] >= pivot && lo < hi) {
                hi--;
            }
            swap(arr, lo, hi);
        }

        swap(arr, hi, right);
        return hi;
    }

//    static int partition(int[] arr, int left, int right) {
//        int lo = left;
//        int hi = right;
//        int pivot = arr[right];
//
//        while (lo < hi) {
//
//            while (arr[lo] < pivot && lo < hi) {
//                lo++;
//            }
//
//            while (arr[hi] >= pivot && lo < hi) {
//                hi--;
//            }
//            swap(arr, lo, hi);
//        }
//
//        swap(arr, right, hi);
//
//        return hi;
//    }

//    static void sort(int[] arr) {
//        quickSort(arr, 0, arr.length - 1);
//    }
//
//    static void quickSort(int[] arr, int lo, int hi) {
//        if (lo >= hi) {
//            return;
//        }
//
//        int pivot = partition(arr, lo, hi);
//
//        quickSort(arr, lo, pivot - 1);
//        quickSort(arr, pivot + 1, hi);
//
//    }
//
//    private static int partition(int[] a, int left, int right) {
//
//        int lo = left;
//        int hi = right;
//        int pivot = a[right];		// 부분리스트의 오른쪽 요소를 피벗으로 설정
//
//        // lo가 hi보다 작을 때 까지만 반복한다.
//        while(lo < hi) {
//
//            /*
//             * hi가 lo보다 크면서, lo의 요소가 pivot보다 큰 원소를
//             * 찾을 떄 까지 lo를 증가시킨다.
//             */
//            while(a[lo] < pivot && lo < hi) {
//                lo++;
//            }
//
//            /*
//             * hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를
//             * 찾을 떄 까지 hi를 감소시킨다.
//             */
//            while(a[hi] >= pivot && lo < hi) {
//                hi--;
//            }
//
//
//            // 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
//            swap(a, lo, hi);
//        }
//
//
//        /*
//         *  마지막으로 맨 처음 pivot으로 설정했던 위치(a[right])의 원소와
//         *  hi가 가리키는 원소를 바꾼다.
//         */
//        swap(a, right, hi);
//
//        // 두 요소가 교환되었다면 피벗이었던 요소는 hi에 위치하므로 hi를 반환한다.
//        return hi;
//    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {50,3,45,4,60,7,5,1,23,13};

        sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

}
