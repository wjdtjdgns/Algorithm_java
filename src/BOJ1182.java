import java.util.Scanner;

public class BOJ1182 {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        S = scanner.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        backtrack(0, 0);

        if (S == 0) count--;
        System.out.println(count);
    }

    static void backtrack(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        backtrack(index + 1, sum);

        backtrack(index + 1, sum + arr[index]);
    }
}
