import java.io.*;
import java.util.*;

public class BOJ1966 {
    static class Document {
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(reader.readLine());

        while (TC-- > 0) {
            String[] NM = reader.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            String[] priorities = reader.readLine().split(" ");

            Deque<Document> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                queue.add(new Document(i, Integer.parseInt(priorities[i])));
            }

            int count = 0;

            while (!queue.isEmpty()) {
                Document cur = queue.poll();

                boolean hasHigherPriority = false;
                for (Document doc : queue) {
                    if (doc.priority > cur.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    queue.add(cur);
                    continue;
                }

                count++;
                if (cur.index == M) {
                    sb.append(count).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
