import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int caseNumber = Integer.parseInt(st.nextToken());
            int[] heights = new int[20];

            for (int j = 0; j < 20; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }

            int moves = countBackwardMoves(heights);
            sb.append(caseNumber).append(" ").append(moves).append("\n");
        }

        System.out.print(sb);
    }

    private static int countBackwardMoves(int[] heights) {
        int moves = 0;
        int[] line = new int[20];
        int size = 0;

        for (int i = 0; i < 20; i++) {
            int curHeight = heights[i];
            int position = size;

            for (int j = 0; j < size; j++) {
                if (line[j] > curHeight) {
                    position = j;
                    break;
                }
            }

            moves += size - position;

            System.arraycopy(line, position, line, position + 1, size - position);
            line[position] = curHeight;
            size++;
        }

        return moves;
    }
}
