import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10845 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            int last = -1;
            for (int i = 0; i < N; i++) {
                String[] commands = br.readLine().split(" ");
                if (commands[0].equals("push")) {
                    queue.offer(Integer.parseInt(commands[1]));
                    last = Integer.parseInt(commands[1]);
                } else if (commands[0].equals("pop")) {
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                } else if (commands[0].equals("size")) {
                    System.out.println(queue.size());
                } else if (commands[0].equals("empty")) {
                    System.out.println(queue.isEmpty() ? 1 : 0);
                } else if (commands[0].equals("front")) {
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                } else if (commands[0].equals("back")) {
                    System.out.println(queue.isEmpty() ? -1 : last);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
