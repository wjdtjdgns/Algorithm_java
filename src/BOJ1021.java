import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ1021 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            final int[] targets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 1; i <= NM[0]; i++) {
                deque.addLast(i);
            }
            int count = 0;
            for (int target : targets) {
                int index = 0;
                for (Integer item : deque) {
                    if (item == target) break;
                    index++;
                }
                int leftRotations = index;
                int rightRotations = deque.size() - index;
                count += Math.min(leftRotations, rightRotations);
                if (leftRotations <= rightRotations) {
                    while (leftRotations-- > 0) {
                        deque.addLast(deque.removeFirst());
                    }
                } else {
                    while (rightRotations-- > 0) {
                        deque.addFirst(deque.removeLast());
                    }
                }
                deque.removeFirst();
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

