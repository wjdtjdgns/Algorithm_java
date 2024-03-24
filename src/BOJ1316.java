import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            int[] alphabet = new int[26];
            char[] word = br.readLine().toCharArray();
            boolean flag = true;
            alphabet[word[0] - 'a'] += 1;
            for (int j = 1; j < word.length; j++) {
                if (word[j - 1] != word[j] && alphabet[word[j] - 'a'] != 0) {
                    flag = false;
                    break;
                }
                alphabet[word[j] - 'a'] += 1;
            }
            if (flag) count++;
        }

        System.out.println(count);
    }
}
