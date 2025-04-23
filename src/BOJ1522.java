import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1522 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();

    int totalA = 0;
    for (char c : s.toCharArray()) {
      if (c == 'a') totalA++;
    }

    String doubled = s + s;
    int minSwaps = Integer.MAX_VALUE;

    int bCount = 0;
    for (int i = 0; i < totalA; i++) {
      if (doubled.charAt(i) == 'b') bCount++;
    }
    minSwaps = bCount;

    for (int i = totalA; i < doubled.length(); i++) {
      if (doubled.charAt(i - totalA) == 'b') bCount--;
      if (doubled.charAt(i) == 'b') bCount++;
      minSwaps = Math.min(minSwaps, bCount);
    }

    System.out.println(minSwaps);
  }
}
