import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String keyword = br.readLine();
        int count = 0;

        while (document.contains(keyword)) {
            int index = document.indexOf(keyword);
            document = document.substring(index + keyword.length());

            count++;
        }

        System.out.println(count);
    }
}
