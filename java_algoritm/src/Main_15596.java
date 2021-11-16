public class Main_15596 {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(sum(a));
    }
    static long sum(int[] a) {
        long ans = 0;
        for (long num : a) {
            ans += num;
        }
        return ans;
    }
}

