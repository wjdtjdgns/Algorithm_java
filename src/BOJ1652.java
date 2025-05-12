import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];

        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().toCharArray();
        }

        int rowSpaces = countSpaces(room, N, true);
        int colSpaces = countSpaces(room, N, false);

        System.out.println(rowSpaces + " " + colSpaces);
    }

    private static int countSpaces(char[][] room, int N, boolean isRow) {
        int total = 0;

        for (int i = 0; i < N; i++) {
            total += countLine(room, N, isRow, i);
        }

        return total;
    }

    private static int countLine(char[][] room, int N, boolean isRow, int index) {
        int len = 0;
        int count = 0;

        for (int j = 0; j < N; j++) {
            char c = isRow ? room[index][j] : room[j][index];

            if (c == '.') {
                len++;
            } else {
                count += isValidSpace(len);
                len = 0;
            }
        }

        count += isValidSpace(len);
        return count;
    }

    private static int isValidSpace(int len) {
        return len >= 2 ? 1 : 0;
    }
}
