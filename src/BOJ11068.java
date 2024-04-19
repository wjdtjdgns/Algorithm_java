import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean foundPalindrome = false;

            for (int base = 2; base <= 64; base++) {
                if (isPalindromeInBase(num, base)) {
                    sb.append(1).append("\n");
                    foundPalindrome = true;
                    break;
                }
            }
            if (!foundPalindrome) {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static boolean isPalindromeInBase(int number, int base) {
        String converted = baseConversion(number, base);
        return isPalindrome(converted);
    }

    private static String baseConversion(int number, int base) {
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
        StringBuilder result = new StringBuilder();

        while (number > 0) {
            result.insert(0, characters.charAt(number % base));
            number /= base;
        }

        return result.toString();
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
