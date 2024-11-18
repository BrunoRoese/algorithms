import problems.ProblemType;
import problems.Strategy;
import problems.backtracking.sum.QueenProblem;
import problems.patternmatching.PatternMatching;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Strategy strategy = new Strategy(List.of(new QueenProblem(), new PatternMatching()));

        strategy.solve(ProblemType.BACKTRACKING_QUEEN_PROBLEM);
    }
}