import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> limit = new HashMap<>(Map.of(
                "Y", 1,
                "F", 2,
                "O", 3
        ));

        Set<String> players = new HashSet<>();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);

        for (int i = 0; i < N; i++) {
            players.add(br.readLine());
        }

        System.out.println((players.size()) / limit.get(input[1]));
    }
}
