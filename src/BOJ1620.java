import java.io.*;
import java.util.*;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> dictionary = new HashMap<>();

        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            dictionary.put(name, String.valueOf(i));
            dictionary.put(String.valueOf(i), name);
        }

        for (int i = 0; i < M; i++) {
            result.append(dictionary.get(br.readLine())).append("\n");
        }

        System.out.println(result);
    }
}
