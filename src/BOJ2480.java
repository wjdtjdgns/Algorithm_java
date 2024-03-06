import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] inputs = br.readLine().split(" ");
        final int[] dice = {Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2])};
        int prize = 0;

        if (dice[0] == dice[1] && dice[1] == dice[2]) {
            prize = 10000 + dice[0] * 1000;
        } else if (dice[0] == dice[1] || dice[1] == dice[2] || dice[0] == dice[2]) {
            int same = dice[0] == dice[1] ? dice[0] : dice[2];
            prize = 1000 + same * 100;
        } else {
            prize = Math.max(dice[0], Math.max(dice[1], dice[2])) * 100;
        }

        System.out.println(prize);
    }
}
