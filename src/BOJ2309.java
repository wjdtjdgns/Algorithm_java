import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = 9;
        int[] man = new int[N];
        int total = 0;

        for (int i = 0; i < N; i++) {
            man[i] = Integer.parseInt(br.readLine());
            total += man[i];
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (total - man[i] - man[j] == 100) {
                    printSevenExcept(man, i, j);
                    return;
                }
            }
        }
    }


    private static void printSevenExcept(int[] man, int skip1, int skip2) {
        int[] answer = new int[7];
        int idx = 0;
        for (int i = 0; i < man.length; i++) {
            if (i == skip1 || i == skip2) continue;
            answer[idx++] = man[i];
        }
        Arrays.sort(answer);
        for (int h : answer) {
            System.out.println(h);
        }
    }
}
