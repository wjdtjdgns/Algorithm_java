import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        boolean[] isDeleted = new boolean[N + 1];
        int count = 0;

        for (int p = 2; p <= N; p++) {
            if (!isDeleted[p]) {
                for (int i = p; i <= N; i += p) {
                    if (!isDeleted[i]) {
                        isDeleted[i] = true;
                        count++;
                        if (count == K) {
                            System.out.println(i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
