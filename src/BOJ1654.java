import java.util.*;
import java.io.*;
public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] KN = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int[] lan = new int[(int)KN[0]];
        for (int i = 0; i < KN[0]; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lan);

        long left = 1;
        long right = lan[(int)KN[0] - 1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < KN[0]; i++) {
                sum += (lan[i] / mid);
            }
            if (sum >= KN[1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

}

