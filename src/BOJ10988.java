import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String word = br.readLine();
        final String reverserWord = new StringBuilder(word).reverse().toString();
        final int isPalindrome = word.equals(reverserWord) ? 1 : 0;

        br.close();
        System.out.println(isPalindrome);
    }
}
