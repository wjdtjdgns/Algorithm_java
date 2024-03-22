import java.util.*;
import java.io.*;

public class BOJ2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int com = Integer.parseInt(br.readLine());
        int net = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < net; i++) {
            int[] pair = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new ArrayList<>());
            }
            map.get(pair[0]).add(pair[1]);

            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new ArrayList<>());
            }
            map.get(pair[1]).add(pair[0]);
        }
        System.out.println(dfs(map, 1).size() - 1);
    }

    public static ArrayList<Integer> dfs(Map<Integer, ArrayList<Integer>> map, int start) {
        ArrayList<Integer> visit = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            if (!visit.contains(node)) {
                visit.add(node);

                if (!map.containsKey(node)) return visit;

                ArrayList<Integer> tmp = map.get(node);

                for (int i = 0; i < tmp.size(); i++) {
                    stack.push(tmp.get(i));
                }
            }
        }
        return visit;
    }
}
