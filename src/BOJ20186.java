import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ20186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] numbers = new int[N][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i][0] = Integer.parseInt(st.nextToken());
            numbers[i][1] = i;
        }

        Arrays.sort(numbers, (a, b) -> b[0] - a[0]);

        int[][] selected = new int[K][2];
        for (int i = 0; i < K; i++) {
            selected[i] = numbers[i];
        }

        Arrays.sort(selected, Comparator.comparingInt(a -> a[1]));

        int score = 0;
        int leftCount = 0;

        for (int i = 0; i < K; i++) {
            score += selected[i][0] - leftCount;
            leftCount++;
        }

        System.out.println(score);
    }
}
