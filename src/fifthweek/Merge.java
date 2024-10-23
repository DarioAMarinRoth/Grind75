package fifthweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {

    public static void main(String[] args) {
        printMatrix(new Merge().merge(new int[][] {{1, 4}, {4, 5}}));
    }


    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergeIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        int[] nextInterval;

        for (int i = 1; i < intervals.length; i++) {
            nextInterval = intervals[i];
            if (overlaps(currentInterval, nextInterval)) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                mergeIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        mergeIntervals.add(currentInterval);
        return mergeIntervals.toArray(new int[mergeIntervals.size()][]);
    }

    private boolean overlaps(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int e : row) {
                System.out.printf("%-5d", e);
            }
            System.out.println();
        }
    }
}
