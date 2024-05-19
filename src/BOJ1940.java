import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        int count = 0;

        int start = 0, end = N - 1;

        while (start < end) {
            int cur = nums[start] + nums[end];
            if (cur == M) {
                count++;
                start++;
                end--;
            }
            else if (cur < M) start++;
            else end--;
        }

        System.out.println(count);
    }
}
