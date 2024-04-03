import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1, j = Integer.parseInt(st.nextToken()) - 1;
            int[] temp = Arrays.copyOf(arr, N);

            while (i < j) {
                arr[i] = temp[j];
                arr[j] = temp[i];
                i++;
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
