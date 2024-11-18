package problems.patternmatching;

import java.util.Random;

public class Utils {
    private static final int MAX_LENGTH = 500_000;
    private static String bigString;
    private static String subString;

    public static String getBigString() {
        if (bigString != null && !bigString.isEmpty()) {
            return bigString;
        }

        StringBuilder builder = new StringBuilder(MAX_LENGTH);
        Random random = new Random();

        for (int i = 0; i < MAX_LENGTH; i++) {
            char randomChar = (char) (random.nextInt(95) + 32);
            builder.append(randomChar);
        }

        bigString = builder.toString();

        return bigString;
    }

    public static String getSubString(int n) {
        if (bigString == null) {
            throw new IllegalStateException("A string grande ainda não foi gerada. Chame generateLargeString() primeiro.");
        }

        if (subString != null && !subString.isEmpty()) {
            return subString;
        }

        if (n > MAX_LENGTH) {
            throw new IllegalArgumentException("O tamanho solicitado excede o limite de 500k caracteres.");
        }

        int startIndex = new Random().nextInt(MAX_LENGTH - n + 1);
        subString = bigString.substring(startIndex, startIndex + n);

        return subString;
    }
}
