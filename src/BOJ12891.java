import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int S = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);
        String dna = br.readLine();
        int[] min = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] current = new int[4];
        for (int i = 0; i < P; i++) {
            updateCount(dna.charAt(i), current, 1);
        }

        int count = 0;
        if (isValid(current, min)) {
            count++;
        }

        for (int i = P; i < S; i++) {
            updateCount(dna.charAt(i - P), current, -1);
            updateCount(dna.charAt(i), current, 1);

            if (isValid(current, min)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void updateCount(char dna, int[] count, int delta) {
        if (dna == 'A') {
            count[0] += delta;
        } else if (dna == 'C') {
            count[1] += delta;
        } else if (dna == 'G') {
            count[2] += delta;
        } else if (dna == 'T') {
            count[3] += delta;
        } else {
            System.out.println("Unsupported");
        }
    }

    public static boolean isValid(int[] cur, int[] min) {
        return cur[0] >= min[0]
                && cur[1] >= min[1]
                && cur[2] >= min[2]
                && cur[3] >= min[3];
    }
}
