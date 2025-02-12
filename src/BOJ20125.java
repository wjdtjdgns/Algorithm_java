import java.util.Scanner;

public class BOJ20125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int heartR = -1, heartC = -1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (board[i][j] == '*') {
                    if (board[i - 1][j] == '*' &&
                            board[i][j - 1] == '*' &&
                            board[i][j + 1] == '*' &&
                            board[i + 1][j] == '*') {
                        heartR = i;
                        heartC = j;
                        break;
                    }
                }
            }
            if (heartR != -1) break;
        }

        int leftArm = 0;
        for (int c = heartC - 1; c >= 0; c--) {
            if (board[heartR][c] == '*') leftArm++;
            else break;
        }

        int rightArm = 0;
        for (int c = heartC + 1; c < N; c++) {
            if (board[heartR][c] == '*') rightArm++;
            else break;
        }

        int waist = 0;
        for (int r = heartR + 1; r < N; r++) {
            if (board[r][heartC] == '*') waist++;
            else break;
        }

        int waistEndR = heartR + waist;

        int leftLeg = 0;
        int leftLegStartR = waistEndR + 1;
        int leftLegStartC = heartC - 1;
        for (int r = leftLegStartR; r < N; r++) {
            if (leftLegStartC >= 0 && board[r][leftLegStartC] == '*') leftLeg++;
            else break;
        }

        int rightLeg = 0;
        int rightLegStartR = waistEndR + 1;
        int rightLegStartC = heartC + 1;
        for (int r = rightLegStartR; r < N; r++) {
            if (rightLegStartC < N && board[r][rightLegStartC] == '*') rightLeg++;
            else break;
        }

        System.out.println((heartR + 1) + " " + (heartC + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
