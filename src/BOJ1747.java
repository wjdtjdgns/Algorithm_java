import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = N; ; i++) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        int sqrt = (int) Math.sqrt(num);

        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public static boolean isPalindrome(int num) {
        String number = Integer.toString(num);
        int len = number.length();

        for (int i = 0; i < len / 2; i++) {
            if (number.charAt(i) != number.charAt(len - i - 1)) return false;
        }

        return true;
    }
}
