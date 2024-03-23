import java.io.*;

public class BOJ8393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        System.out.println((n *( n + 1)) / 2);
    }
}
