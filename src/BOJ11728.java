import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] AB = new int[NM[0] + NM[1]];
        System.arraycopy(A, 0, AB, 0, NM[0]);
        System.arraycopy(B, 0, AB, NM[0], NM[1]);
        Arrays.sort(AB);

        StringBuilder sb = new StringBuilder();
        for (int i : AB) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
