import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] splitedByMinus = input.split("-");
        int result = sum(splitedByMinus[0]);

        for (int i = 1; i < splitedByMinus.length; i++) {
            result -= sum(splitedByMinus[i]);
        }

        System.out.println(result);
    }

    private static int sum(String str) {
        String[] splitedByPlus = str.split("\\+");

        int sum = 0;

        for (String ele : splitedByPlus) {
            sum += Integer.parseInt(ele);
        }

        return sum;
    }
}
