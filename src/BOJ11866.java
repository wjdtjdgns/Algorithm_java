import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class BOJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();

        for (int i = 1; i <= NK[0]; i++) {
            q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            count++;
            if (count == NK[1]) {
                res.add(q.poll());
                count = 0;
            } else {
                q.add(q.poll());
            }
        }

        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(", ", "<", ">")));
    }
}