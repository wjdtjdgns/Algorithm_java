import java.util.Scanner;

public class BOJ10974 {
    static int N;
    static int[] selected;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        selected = new int[N];
        used = new boolean[N + 1];

        backtrack(0);
    }

    static void backtrack(int depth) {
        if (depth == N) {
            for (int num : selected) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                selected[depth] = i;
                backtrack(depth + 1);
                used[i] = false;
            }
        }
    }
}
