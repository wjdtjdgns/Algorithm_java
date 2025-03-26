import java.util.Scanner;

public class BOJ11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int moveCount = (int) Math.pow(2, n) - 1;
        System.out.println(moveCount);

        hanoi(n, 1, 3, 2);
        System.out.print(sb);
    }

    public static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, via, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, via, to, from);
    }
}
