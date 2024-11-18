package problems.patternmatching;

import problems.Problem;
import problems.ProblemType;
import problems.exceptions.BadValueException;

import java.util.List;
import java.util.Scanner;

public class PatternMatching implements Problem {

    private String s1;
    private String s2;
    private int finalResult;

    @Override
    public void solve() {
        startValue();

        findString();

        System.out.println(this);
    }

    public void startValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two string separated by space: ");
        String list = scanner.nextLine();

        List<String> value = List.of(list.split(" "));

        if (value.size() > 2) {
            throw new BadValueException("Only two values are allowed");
        }

        this.s1 = value.getFirst();
        this.s2 = value.get(1);
    }

    @Override
    public ProblemType getType() {
        return ProblemType.PATTERN_MATCHING;
    }

    private void findString() {
        int s2Size = s2.length();
        char[] result = new char[s2Size];
        int s2CharPos = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(s2CharPos)) {
                result[s2CharPos] = s1.charAt(i);
                s2CharPos++;

                if (checkCompletion(result, s2)) {
                    finalResult = (i - s2.length()) + 1;
                    return;
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

    @Override
    public String toString() {
        return "PatternMatching{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", finalResult=" + finalResult +
                '}';
    }
}
