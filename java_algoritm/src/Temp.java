import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;


public class Temp {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String[] input = br.readLine().split("");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            System.out.println("Case #" + i + ": " + (A + B));
        }

    }
}
