import java.io.*;
import java.util.*;

public class BOJ24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] type = new int[N];
        for (int i = 0; i < N; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] elements = new int[N];
        for (int i = 0; i < N; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] sequence = new int[M];
        for (int i = 0; i < M; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (type[i] == 0) {
                queue.addLast(elements[i]);
            }
        }

        for (int i = 0; i < M; i++) {
            int input = sequence[i];

            if (!queue.isEmpty()) {
                queue.addFirst(input);
                sb.append(queue.removeLast()).append(" ");
            } else {
                sb.append(input).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
