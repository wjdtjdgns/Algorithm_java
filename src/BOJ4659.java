import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class BOJ4659 {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String line;

        while (!(line = reader.readLine()).equals("end")) {
            boolean hasVowel = hasVowels(line);
            boolean isValid = isValidSequence(line);

            result.append(formatResult(line, hasVowel && isValid)).append(System.lineSeparator());
        }

        System.out.println(result.toString());
    }

    public static boolean hasVowels(String word) {
        for (char c : word.toCharArray()) {
            if (VOWELS.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidSequence(String word) {
        int vowelCount = 0, consonantCount = 0;
        char last = ' ';
        int repeatCount = 1;

        for (char cur : word.toCharArray()) {
            boolean isVowel = VOWELS.contains(cur);

            if (isVowel) {
                vowelCount++;
                consonantCount = 0;
            } else {
                consonantCount++;
                vowelCount = 0;
            }

            if (vowelCount == 3 || consonantCount == 3) {
                return false;
            }

            if (cur == last) {
                repeatCount++;
                if (repeatCount == 2 && !(cur == 'e' || cur == 'o')) {
                    return false;
                }
            } else {
                repeatCount = 1;
            }

            last = cur;
        }
        return true;
    }

    public static String formatResult(String word, boolean isAcceptable) {
        return String.format("<%s> is %sacceptable.", word, isAcceptable ? "" : "not ");
    }
}
