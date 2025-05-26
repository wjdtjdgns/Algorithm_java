import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14888 {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        numbers = makeIntArray(br.readLine().split(" "), N);
        operators = makeIntArray(br.readLine().split(" "), 4);

        dfs(1, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static int[] makeIntArray(String[] input, int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(input[i]);
        }

        return result;
    }

    private static void dfs(int depth, int result) {
        if (depth == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0: dfs(depth + 1, result + numbers[depth]); break;
                    case 1: dfs(depth + 1, result - numbers[depth]); break;
                    case 2: dfs(depth + 1, result * numbers[depth]); break;
                    case 3:
                        if (result < 0) {
                            dfs(depth + 1, -(-result / numbers[depth]));
                        } else {
                            dfs(depth + 1, result / numbers[depth]);
                        }
                        break;
                }

                operators[i]++;
            }
        }
    }
}
