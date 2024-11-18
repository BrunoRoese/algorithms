package problems.patternmatching;

import problems.Problem;
import problems.ProblemType;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import static problems.patternmatching.Utils.*;

public class PatternMatching implements Problem {

    private int finalResult;
    private Duration timeCounter;

    @Override
    public void solve() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two string separated by space: ");
        String list = scanner.nextLine();

        List<String> value = List.of(list.split(" "));

        String largeString;
        String subString;
        if (value.size() < 2) {
            largeString = getBigString();
            subString = getSubString(5);
        } else {
            largeString = value.getFirst();
            subString = value.getLast();
        }

        long startTime = System.currentTimeMillis();
        findString(largeString, subString);
        long endTime = System.currentTimeMillis();

        this.timeCounter = Duration.ofMillis(endTime - startTime);

        System.out.println(this);
    }

    @Override
    public ProblemType getType() {
        return ProblemType.PATTERN_MATCHING;
    }

    private void findString(String s1, String s2) {
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
        return "Final result counter: " +
                finalResult +
                "\n" +
                "Time counter: " +
                timeCounter;
    }
}
