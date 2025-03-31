import java.util.*;

public class BOJ11652 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long num = scanner.nextLong();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long mostFrequent = Long.MAX_VALUE;
        int maxCount = 0;

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            long key = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && key < mostFrequent)) {
                maxCount = count;
                mostFrequent = key;
            }
        }

        System.out.println(mostFrequent);
    }
}
