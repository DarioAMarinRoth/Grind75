package secondweek;

public class ClimbingStairs {

    public int climbStairs(int n) {
        switch (n) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                int combinations = 0;
                int previous = 2;
                int previousPrevious = 1;
                for (int i = 3; i <= n; i++) {
                    combinations = previous + previousPrevious;
                    previousPrevious = previous;
                    previous = combinations;
                }
                return combinations;
        }
    }
}
