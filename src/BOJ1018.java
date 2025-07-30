import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int minPaint = 64;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minPaint = Math.min(minPaint, countRepaint(board, i, j));
            }
        }

        System.out.println(minPaint);
    }

    private static int countRepaint(char[][] board, int x, int y) {
        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char cur = board[x + i][y + j];

                if ((i + j) % 2 == 0) {
                    if (cur != 'W') cnt1++;
                    if (cur != 'B') cnt2++;
                } else {
                    if (cur != 'B') cnt1++;
                    if (cur != 'W') cnt2++;
                }
            }
        }
        return Math.min(cnt1, cnt2);
    }
}
