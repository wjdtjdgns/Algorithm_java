import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13300 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] temp = br.readLine().split(" ");
            final int size = Integer.parseInt(temp[0]), K = Integer.parseInt(temp[1]);
            final int[] w = new int[6];
            final int[] m = new int[6];
            for (int i = 0; i < size; i++) {
                temp = br.readLine().split(" ");
                int S = Integer.parseInt(temp[0]);
                int Y = Integer.parseInt(temp[1]);
                if (S == 0) w[Y - 1]++;
                else m[Y - 1]++;
            }
            int count = 0;
            for (int n : w) {
                count += (n / K);
                if (n % K != 0) count++;
            }
            for (int n : m) {
                count += (n / K);
                if (n % K != 0) count++;
            }

            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
