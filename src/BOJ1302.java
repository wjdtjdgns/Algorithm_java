import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (hm.containsKey(input)) {
                hm.put(input, hm.get(input) + 1);
            } else {
                hm.put(input, 1);
            }
        }

        String result = "";
        int max = 0;

        for (String s : hm.keySet()) {
            int currentCount = hm.get(s);
            if (currentCount > max || (currentCount == max && (result.isEmpty() || s.compareTo(result) < 0))) {
                max = currentCount;
                result = s;
            }
        }

        System.out.println(result);
    }
}
