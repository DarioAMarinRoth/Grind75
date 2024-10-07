package thirdweek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        InsertInterval ins = new InsertInterval();
        printMatrix(ins.insert(intervals, newInterval));
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0 ) {
            return new int[][]{newInterval};
        }


        List<int[]> intervalList;

        if (newInterval[1] < intervals[0][0]) {
            intervalList = new ArrayList<>(Arrays.asList(intervals));
            intervalList.addFirst(newInterval);
            return intervalList.toArray(new int[intervalList.size()][]);
        }

        if (newInterval[0] > intervals[intervals.length - 1][1]) {
            intervalList = new ArrayList<>(Arrays.asList(intervals));
            intervalList.addLast(newInterval);
            return intervalList.toArray(new int[intervalList.size()][]);
        }


        boolean overlapping = false;
        intervalList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (newInterval[0] > interval[1] && newInterval[1] < intervals[i + 1][0]) {
                intervalList.add(interval);
                intervalList.add(newInterval);
                continue;
            }

            if (overlaps(newInterval, interval)) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                if (overlapping) {
                    continue;
                }
                intervalList.add(newInterval);
                overlapping = true;
                continue;
            }

            intervalList.add(interval);
        }

        return intervalList.toArray(new int[intervalList.size()][]);
    }

    private boolean overlaps(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }
}
