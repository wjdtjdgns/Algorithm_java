import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BOJ11328 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int size = Integer.parseInt(br.readLine());
            for (int i = 0; i < size; i++) {
                String[] str = br.readLine().split(" ");
                String[] firstStr = str[0].split("");
                Arrays.sort(firstStr);
                String[] secondStr = str[1].split("");
                Arrays.sort(secondStr);
                String first = Arrays.stream(firstStr).collect(Collectors.joining(""));
                String second = Arrays.stream(secondStr).collect(Collectors.joining(""));
                System.out.println(first.equals(second) ? "Possible" : "Impossible");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
