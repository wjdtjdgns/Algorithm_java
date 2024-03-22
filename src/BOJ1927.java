import java.io.*;
import java.util.*;
public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                System.out.println(pq.isEmpty() ? 0 : pq.poll());
            } else {
                pq.add(x);
            }
        }
    }
}
