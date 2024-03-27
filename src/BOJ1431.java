import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int o1Sum = 0;
                    int o2Sum = 0;

                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i))) {
                            o1Sum += o1.charAt(i) - '0';
                        }
                        if (Character.isDigit(o2.charAt(i))) {
                            o2Sum += o2.charAt(i) - '0';
                        }
                    }

                    if (o1Sum == o2Sum) {
                        return o1.compareTo(o2);
                    }

                    return o1Sum - o2Sum;
                }

                return o1.length() - o2.length();
            }
        };

        Arrays.sort(words, comparator);

        for (String s : words) {
            System.out.println(s);
        }
    }
}
