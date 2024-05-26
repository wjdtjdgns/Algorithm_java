import java.io.*;

public class BOJ15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            bw.write(String.valueOf(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1])));
            bw.newLine();
        }
        bw.flush();
    }
}
