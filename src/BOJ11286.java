import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (cur == 0) {
                System.out.println(pq.isEmpty() ? 0 : pq.poll()[0]);
            } else {
                pq.add(new int[]{cur, Math.abs(cur)});
            }
        }
    }
}
