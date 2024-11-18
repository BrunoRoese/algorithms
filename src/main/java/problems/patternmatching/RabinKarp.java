package problems.patternmatching;

import problems.Problem;
import problems.ProblemType;
import problems.exceptions.BadValueException;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import static problems.patternmatching.Utils.*;

public class RabinKarp implements Problem {

    private int counter = 0;
    private Duration timeCounter;

    @Override
    public void solve() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two string separated by space: ");
        String values = scanner.nextLine();

        List<String> stringList = List.of(values.split(" "));

        String largeString;
        String subString;

        if (stringList.size() < 2) {
            largeString = getBigString();
            subString = getSubString(5);
        } else {
            largeString = stringList.getFirst();
            subString = stringList.getLast();
        }

        long startTime = System.currentTimeMillis();
        search(largeString, subString);
        long endTime = System.currentTimeMillis();

        this.timeCounter = Duration.ofMillis(endTime - startTime);

        System.out.println(this);
    }

    @Override
    public ProblemType getType() {
        return ProblemType.RABIN_KARP;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("Counter: ")
                .append(counter)
                .append("\n")
                .append("Time: ")
                .append(timeCounter);

        return sb.toString();
    }

    private int search(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();
        long patternHash = hornerHash(pattern, patternLength);

        for (int i = 0; i < textLength; i++) {
            long currentTextHash = hornerHash(text.substring(i, i + patternLength), patternLength);

            if (patternHash == currentTextHash) {
                counter = i;
                return i;
            }
        }

        throw new RuntimeException("No value was found");
    }

    private long hornerHash(String pattern, int patternLength) {
        long hash = 0;
        int alphabetSize = 26;

        for (int i = 0; i < patternLength; i++) {
            hash = (hash * alphabetSize + pattern.charAt(i)) % 2147483647;
        }

        return hash;
    }
}
