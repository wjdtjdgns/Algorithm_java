import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int M = Integer.parseInt(reader.readLine());
        int bitSet = 0;

        for (int i = 0; i < M; i++) {
            String[] input = reader.readLine().split(" ");
            String op = input[0];

            if (op.equals("add")) {
                int x = Integer.parseInt(input[1]);
                bitSet |= (1 << (x - 1));
            } else if (op.equals("remove")) {
                int x = Integer.parseInt(input[1]);
                bitSet &= ~(1 << (x - 1));
            } else if (op.equals("check")) {
                int x = Integer.parseInt(input[1]);
                output.append((bitSet & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
            } else if (op.equals("toggle")) {
                int x = Integer.parseInt(input[1]);
                bitSet ^= (1 << (x - 1));
            } else if (op.equals("all")) {
                bitSet = (1 << 20) - 1;
            } else if (op.equals("empty")) {
                bitSet = 0;
            }
        }

        System.out.print(output);
    }
}
