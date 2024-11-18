package problems;

import java.util.List;

public class Strategy {

    List<Problem> problems;

    public Strategy(List<Problem> problems) {
        this.problems = problems;
    }

    public void solve(ProblemType types) {
        this.problems
                .stream()
                .filter(problem -> problem.getType().equals(types))
                .peek(problem -> System.out.println("Solving " + problem.getType()))
                .findFirst()
                .ifPresent(Problem::solve);
    }
}
