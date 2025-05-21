import java.io.*;
import java.util.*;

public class BOJ2693 {
    static final int N = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[] array = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            System.out.println(getNthLargest(array, N));
        }
    }

    public static int getNthLargest(int[] array, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : array) {
            pq.offer(num);
            if (pq.size() > n) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}
