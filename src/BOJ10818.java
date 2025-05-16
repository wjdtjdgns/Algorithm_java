import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max=  -1000000;
        for(int i = 0; i < n; i++) {
            int current = Integer.parseInt(line[i]);
            min = Math.min(min, current);
            max = Math.max(max, current);
        }

        System.out.println(min + " " + max);
    }
}