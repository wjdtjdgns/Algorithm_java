import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] C = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer>[] dataStructures = new ArrayDeque[N];
        for (int i = 0; i < N; i++) {
            dataStructures[i] = new ArrayDeque<>();
            dataStructures[i].add(B[i]);
        }

        for (int x : C) {
            int currentValue = x;

            for (int i = 0; i < N; i++) {
                dataStructures[i].addLast(currentValue);

                if (A[i] == 0) {
                    currentValue = dataStructures[i].removeFirst();
                } else {
                    currentValue = dataStructures[i].removeLast();
                }
            }

            sb.append(currentValue).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
