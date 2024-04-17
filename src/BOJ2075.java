import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (String num : line) {
                int value = Integer.parseInt(num);

                if (pq.size() < N) {
                    pq.offer(value);
                } else if (pq.peek() < value) {
                    pq.poll();
                    pq.offer(value);
                }
            }
        }

        System.out.println(pq.peek());
    }
}
