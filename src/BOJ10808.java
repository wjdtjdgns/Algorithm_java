import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ10808 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final String word = br.readLine();
            final int[] alphabet = new int[26];

            for (int i = 0; i < word.length(); i++) {
                int n = word.charAt(i) - 'a';
                alphabet[n]++;
            }
            String result = Arrays.stream(alphabet).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
