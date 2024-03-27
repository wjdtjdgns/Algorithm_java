import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BOJ2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NC = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> firstOccurrence = new HashMap<>();
        Integer[] m = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        for (int i = 0; i < NC[0]; i++) {
            freq.put(m[i], freq.getOrDefault(m[i], 0) + 1);
            firstOccurrence.putIfAbsent(m[i], i);
        }

        Arrays.sort(m, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int freqCompare = freq.get(o2).compareTo(freq.get(o1));
                if (freqCompare == 0) {
                    return firstOccurrence.get(o1).compareTo(firstOccurrence.get(o2));
                }
                return freqCompare;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i : m) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
