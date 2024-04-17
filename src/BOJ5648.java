import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        final int N = Integer.parseInt(st.nextToken());
        int i = 0;
        long[] arr = new long[N];
        while (st.hasMoreTokens()) {
            arr[i] = Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString());
            i++;
        }

        while (i < N) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[i] = Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString());
                i++;
            }
        }
        Arrays.sort(arr);

        for (long e : arr) {
            System.out.println(e);
        }

    }
}
