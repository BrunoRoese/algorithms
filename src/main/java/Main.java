import problems.ProblemType;
import problems.Strategy;
import problems.backtracking.sum.QueenProblem;
import problems.patternmatching.PatternMatching;
import problems.patternmatching.RabinKarp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Strategy strategy = new Strategy(List.of(new QueenProblem(), new PatternMatching(), new RabinKarp()));

        strategy.solve(ProblemType.RABIN_KARP);
        strategy.solve(ProblemType.PATTERN_MATCHING);
    }
}