import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1475 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final String number = br.readLine();
            final int[] count = new int[9];
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) - '0' == 9) {
                    count[6]++;
                } else {
                    count[number.charAt(i) - '0']++;
                }
            }
            count[6] = (count[6] % 2 == 0) ? count[6] / 2 : count[6] / 2 + 1;

            int max = 0;

            for (int i : count) {
                max = Math.max(i, max);
            }

            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
