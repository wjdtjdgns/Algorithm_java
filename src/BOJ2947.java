import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] piece = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            piece[i] = Integer.parseInt(input[i]);
        }

        while (!isOrdered(piece)) {
            for (int i = 1; i < 5; i++) {
                if (piece[i - 1] > piece[i]) {
                    int temp = piece[i - 1];
                    piece[i - 1] = piece[i];
                    piece[i] = temp;

                    print(piece);
                }

            }
        }
    }

    private static boolean isOrdered(int[] arr) {
        for (int i = 1; i <= 5; i++) {
            if (arr[i - 1] != i) {
                return false;
            }
        }

        return true;
    }

    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
