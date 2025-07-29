import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;

        while (!(input = br.readLine()).equalsIgnoreCase("0")) {
            System.out.println(isPalindrome(input) ? "yes" : "no");
        }
    }

    public static boolean isPalindrome(String str) {

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
