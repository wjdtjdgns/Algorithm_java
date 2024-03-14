import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class BOJ1158 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final String[] s = br.readLine().split(" ");
            final int N = Integer.parseInt(s[0]), K = Integer.parseInt(s[1]);
            Queue<Integer> queue = new LinkedList<>();
            int count = 0;
            Queue<Integer> result = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                queue.add(i);
            }
            while (!queue.isEmpty()) {
                count++;
                if (count == K) {
                    result.add(queue.poll());
                    count = 0;
                } else {
                    queue.add(queue.poll());
                }
            }
            System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(", ", "<", ">")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
