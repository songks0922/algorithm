import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1270 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }

            int[] arr = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .mapToInt(Map.Entry::getKey).toArray();

            int sum = map.values().stream().mapToInt(Integer::intValue).sum();


            if (sum / 2 <= map.get(arr[0]) && map.get(arr[0]) != map.get(arr[1])) {
                System.out.println(arr[0]);
            } else {
                System.out.println("SYJKGW");
            }

        }
    }
}
