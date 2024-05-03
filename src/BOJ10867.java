import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        String[] input = br.readLine().split(" ");

        for (String s : input) {
            set.add(Integer.parseInt(s));
        }

        int[] sorted = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(sorted);

        StringBuilder result = new StringBuilder();
        for (int num : sorted) {
            result.append(num).append(" ");
        }

        System.out.println(result.toString().trim());
    }

}
