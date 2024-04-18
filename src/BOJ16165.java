import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        HashMap<String, String[]> girlGroup = new HashMap<>();
        HashMap<String, String> names = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            int num = Integer.parseInt(br.readLine());
            girlGroup.put(groupName, new String[num]);
            for (int j = 0; j < num; j++) {
                String name = br.readLine();
                girlGroup.get(groupName)[j] = name;
                names.put(name, groupName);
            }
        }

        for (String n : girlGroup.keySet()) {
            Arrays.sort(girlGroup.get(n));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int quiz = Integer.parseInt(br.readLine());
            if (quiz == 0) {
                String[] members = girlGroup.get(name);
                for (String member : members) {
                    sb.append(member).append("\n");
                }
            } else {
                sb.append(names.get(name)).append("\n");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
