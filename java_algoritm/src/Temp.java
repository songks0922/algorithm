import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Temp {


    public static void main(String[] args) throws IOException {
        List<Integer> array = Arrays.asList(new Integer[]{1, 2, 3, 4});
        List<Integer> array2 = Arrays.asList(new Integer[]{1, 2});

        ArrayList<Integer> collect = array.stream().filter(e -> !array2.contains(e)).collect(Collectors.toCollection(ArrayList::new));

        for (Integer integer : collect) {
            System.out.println("integer = " + integer);
        }

    }
}
