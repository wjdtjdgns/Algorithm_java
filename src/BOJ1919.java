import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1919 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            char[] first = br.readLine().toCharArray();
            char[] second = br.readLine().toCharArray();
            int[] count = new int[26];
            int result = 0;

            for (char s : first) {
                count[s - 'a']++;
            }
            for (char s : second) {
                count[s - 'a']--;
            }
            for (int n : count) {
                if (n > 0) result += n;
                else if (n < 0) result += -n;
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
