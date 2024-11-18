package problems;

import problems.exceptions.BadValueException;

import java.util.List;

public class Strategy {

    List<Problem> problems;

    public Strategy(List<Problem> problems) {
        this.problems = problems;
    }

    public void solve(ProblemType types) {
        try {
            this.problems
                    .stream()
                    .filter(problem -> problem.getType().equals(types))
                    .peek(problem -> System.out.println("Solving " + problem.getType()))
                    .findFirst()
                    .ifPresent(Problem::solve);
        } catch (BadValueException be) {
            System.out.println("Bad value entered, try again");
            solve(types);
        }
    }
}
