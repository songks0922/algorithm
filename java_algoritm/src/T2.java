import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class T2 {

    static class FileInfo {
        String name;
        String size;

        FileInfo(String name, String size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            FileInfo other = (FileInfo) o;
            return name.equals(other.name) && size.equals(other.size);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, size);
        }

        public int getSize() {
            if (size.endsWith("KB")) {
                return Integer.parseInt(size.substring(0, size.length() - 2)) * 1024;
            }

            if (size.endsWith("B")) {
                return Integer.parseInt(size.substring(0, size.length() - 1));
            }

            return -1;
        }
    }

    static int[] solution(String[][] folders, String[][] files, String[] selected, String[] expected) {
        int[] answer = new int[2];
        Map<String, List<String>> folderMap = new HashMap<>();
        Map<String, List<FileInfo>> fileMap = new HashMap<>();
        Iterator<String> iter = folderMap.keySet().iterator();
        for (int i = 0; i < folders.length; i++) {
            String name = folders[i][1];
            if (folderMap.containsKey(name)) {
                folderMap.get(name).add(folders[i][0]);
                continue;
            }
            folderMap.put(name, new ArrayList<>(Arrays.asList(folders[i][0])));
        }

        for (String[] file : files) {
            String fileName = file[0], size = file[1], folderName = file[2];
            if (fileMap.containsKey(folderName)) {
                fileMap.get(folderName).add(new FileInfo(fileName, size));
                continue;
            }
            fileMap.put(folderName, new ArrayList<>(Arrays.asList(new FileInfo(fileName, size))));
        }


        Queue<String> queue = new LinkedList<>();
        List<FileInfo> check = new ArrayList<>();

        for (String target : selected) {
            queue.add(target);
        }

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (!fileMap.containsKey(curr)) {
                for (String folder : folderMap.get(curr)) {
                    queue.add(folder);
                }
                continue;
            }
            for (FileInfo each : fileMap.get(curr)) {
                if (!check.contains(each)) {
                    check.add(each);
                }
            }

            if (!folderMap.containsKey(curr)) {
                continue;
            }

            if (fileMap.containsKey(curr)) {
                for (String folder : folderMap.get(curr)) {
                    if (!queue.contains(folder)) {
                        queue.add(folder);
                    }
                }
            }
        }

        for (String remove : expected) {
            for (FileInfo each : check) {
                if (each.name.equals(remove)) {
                    check.remove(each);
                    break;
                }
            }
        }

        int totalSize = 0;

        for (FileInfo each : check) {
            totalSize += each.getSize();
        }

        System.out.println(totalSize + " " + check.size());
        List<String> st = new ArrayList<>();
        Collections.sort(st, Comparator.reverseOrder());

        return answer;
    }

    public static void main(String[] args) {
//        String[][] folders = {{"animal", "root"}, {"fruit", "root"}};
//        String[][] files = {{"cat", "1B", "animal"}, {"dog", "2B", "animal"}, {"apple", "4B", "fruit"}};
//        String[] selected = {"root"};
//        String[] expected = {"apple"};

        String[][] folders = {{"food", "root"}, {"meat", "root"}, {"fruit", "food"}, {"animal", "root"}};
        String[][] files = {{"cat", "1B", "animal"}, {"dog", "2B", "animal"}, {"fork", "1KB", "meat"},
            {"beef", "8KB", "meat"}, {"apple", "4B", "fruit"}, {"fire", "83B", "root"}};
        String[] selected = {"root", "meat"};
        String[] expected = {"fork", "apple"};
        int[] solution = solution(folders, files, selected, expected);

    }

}
