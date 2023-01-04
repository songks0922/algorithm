import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main_1043 {

    public static void main(String[] args) throws IOException {

        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.add(3, 10);

        for (int number : list) {
            System.out.println(number);
        }

        
    }

}
