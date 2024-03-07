import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ2577 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int first = Integer.parseInt(br.readLine());
            final int second = Integer.parseInt(br.readLine());
            final int third = Integer.parseInt(br.readLine());
            int mul = first * second * third;
            final int[] numbers = new int[10];
            while (mul > 0) {
                numbers[mul%10]++;
                mul /= 10;
            }
            final String result = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
