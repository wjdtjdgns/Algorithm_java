import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2444 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int row = Integer.parseInt(br.readLine());
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row - i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < (2 * i + 1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            for (int i = row - 2; i >= 0; i--) {
                for(int j = 0; j < row - i - 1; j++) {
                    System.out.print(" ");
                }
                for(int j = 0; j < (2 * i + 1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
