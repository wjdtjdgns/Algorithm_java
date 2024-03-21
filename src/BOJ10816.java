import java.util.*;
import java.io.*;
public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if (map.containsKey(nArr[i])) {
                map.put(nArr[i], map.get(nArr[i]) + 1);
            } else {
                map.put(nArr[i], 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (!map.containsKey(mArr[i])) {
                sb.append("0").append(" ");
            } else {
                sb.append(String.valueOf(map.get(mArr[i]))).append(" ");
            }
        }
        System.out.println(sb.toString().trim());

    }
}
