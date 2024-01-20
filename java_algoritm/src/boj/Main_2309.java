package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2309 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> candidate = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            candidate.add(Integer.parseInt(br.readLine()));
        }

        List<Integer> result = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                for (int k = j + 1; k < 9; k++) {
                    for (int a = k + 1; a < 9; a++) {
                        for (int b = a + 1; b < 9; b++) {
                            for (int c = b + 1; c < 9; c++) {
                                for (int d = c + 1; d < 9; d++) {
                                    if (candidate.get(i) + candidate.get(j) + candidate.get(k) + candidate.get(
                                        a) + candidate.get(b) + candidate.get(c) + candidate.get(d) == 100 && flag == false) {

                                        result.add(candidate.get(i));
                                        result.add(candidate.get(j));
                                        result.add(candidate.get(k));
                                        result.add(candidate.get(a));
                                        result.add(candidate.get(b));
                                        result.add(candidate.get(c));
                                        result.add(candidate.get(d));
                                        flag = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Collections.sort(result);

        for (Integer num : result) {
            System.out.println(num);
        }

    }
}
