package boj.all1000.p1100;

import static java.lang.Math.pow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main_1132 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<Character> first = new ArrayList<>();
        Map<Character, Long> alpha = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            alpha.put((char)('A' + i), 0L);
        }

        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }

        for (int i = 0; i < arr.size(); i++) {
            int len = arr.get(i).length();
            for (int j = 0; j < len; j++) {
                char target = arr.get(i).charAt(j);
                alpha.put(target, (long) (alpha.get(target) + pow(10, len-j-1)));
            }
            if (!first.contains(arr.get(i).charAt(0))) first.add(arr.get(i).charAt(0));
        }

        Map<Character, Long> sortedMap = sortingMap(alpha);
        ArrayList<Character> notFirst = findNotFirst(first, sortedMap);
        if (!notFirst.isEmpty()) {
            char minKey = findMinKey(sortedMap, notFirst);
            Long minKeyValue = sortedMap.get(minKey);
            sortedMap.remove(minKey);
            sortedMap.put(minKey, minKeyValue);
        }

        long result = 0, index = 0;

        for(Map.Entry<Character, Long> entry : sortedMap.entrySet()) {
            result += entry.getValue() * (9-index);
            index++;
        }

        System.out.println(result);
    }

    private static ArrayList<Character> findNotFirst(ArrayList<Character> first, Map<Character, Long> sortedMap) {
        ArrayList<Character> notFirst = new ArrayList<>();
        for(Map.Entry<Character, Long> entry : sortedMap.entrySet()) {
            if (!first.contains(entry.getKey())) {
                notFirst.add(entry.getKey());
            }
        }
        return notFirst;
    }

    private static Map<Character, Long> sortingMap(Map<Character, Long> alpha) {
        List<Map.Entry<Character, Long>> list = new LinkedList<>(alpha.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Long>>() {
            @Override
            public int compare(Map.Entry<Character, Long> o1, Map.Entry<Character, Long> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        Map<Character, Long> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<Character, Long>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<Character, Long> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    static char findMinKey(Map<Character, Long> sortedMap, ArrayList<Character> list){
        char ans = list.get(0);
        Long minValue = sortedMap.get(ans);
        for (int i = 0; i < list.size(); i++) {
            if (minValue > sortedMap.get(list.get(i))) {
                minValue = sortedMap.get(list.get(i));
                ans = list.get(i);
            }
        }
        return ans;
    }
}