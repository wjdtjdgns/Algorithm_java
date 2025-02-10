import java.io.*;
import java.util.*;

public class BOJ6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = "";
        while(!(line = br.readLine()).equals("0")) {
            String[] input = line.split(" ");
            int size = Integer.parseInt(input[0]);
            int[] set = new int[size];
            for (int i = 0; i < size; i++) {
                set[i] = Integer.parseInt(input[i + 1]);
            }

            List<List<Integer>> combinations = new ArrayList<>();
            generateCombinations(set, 0, 6, new ArrayList<>(), combinations);

            for (List<Integer> combination : combinations) {
                for (Integer i : combination) {
                    sb.append(i).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void generateCombinations(int[] set, int start, int r, List<Integer> current, List<List<Integer>> combinations) {
        if (current.size() == r) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < set.length; i++) {
            current.add(set[i]);
            generateCombinations(set, i + 1, r, current, combinations);
            current.remove(current.size() - 1);
        }
    }
}