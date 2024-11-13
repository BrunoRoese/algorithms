import backtracking.sum.QueenProblem;
import patternmatching.PatternMatching;

public class Main {
    public static void main(String[] args) {
        PatternMatching patternMatching = new PatternMatching();

        System.out.println(patternMatching.findString("ABCDCBDCBDACBDABDCBADF", "ADF"));
    }
}