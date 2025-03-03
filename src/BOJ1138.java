import java.util.Scanner;

public class BOJ1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] leftCount = new int[N];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            leftCount[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int count = leftCount[i];
            for (int j = 0; j < N; j++) {
                if (count == 0 && result[j] == 0) {
                    result[j] = i + 1;
                    break;
                } else if (result[j] == 0) {
                    count--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
