import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] subStr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            subStr[i] = str.substring(i);
        }
        Arrays.sort(subStr);
        for (String s : subStr) {
            System.out.println(s);
        }
    }
}
