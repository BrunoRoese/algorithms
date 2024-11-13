package patternmatching;

public class PatternMatching {

    public int findString(String s1, String s2) {
        int s2Size = s2.length();
        char[] result = new char[s2Size];
        int s2CharPos = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(s2CharPos)) {
                result[s2CharPos] = s1.charAt(i);
                s2CharPos++;

                if (checkCompletion(result, s2)) {
                    return (i - s2.length()) + 1;
                }

                continue;
            }

            result = new char[s2Size];
            s2CharPos = 0;
        }

        throw new RuntimeException("String not found");
    }

    private boolean checkCompletion(char[] result, String objective) {
        for (int i = 0; i < result.length; i++) {
            if (!(result[i] == objective.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
