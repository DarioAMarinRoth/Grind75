package fourthweek;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {

        int time = 0;
        Queue<int[]> rottenOranges = new ArrayDeque<>();
        int[][] oranges = new int[grid.length][grid[0].length]; // No piso el input porque me da asco.

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                oranges[i][j] = grid[i][j];
                if (grid[i][j] == 2) {
                    rottenOranges.add(new int[]{i, j, 0});
                }
            }
        }

        int[] orange;
        while (!rottenOranges.isEmpty()) {
            orange = rottenOranges.poll();
            time = Math.max(time,orange[2]);
            updateQueue(rottenOranges, oranges, orange);
        }

        for (int[] row : oranges) {
            for (int element : row) {
                if (element == 1) {
                    return -1;
                }
            }
        }

        return time;
    }

    private void updateQueue(Queue queue, int[][] grid, int[] orange) {
        int i = orange[0];
        int j = orange[1];
        int time = orange[2];

        if (inArea(grid, i + 1, j) && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            queue.add(new int[] {i + 1, j, time + 1});
        }
        if (inArea(grid, i - 1, j) && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            queue.add(new int[] {i - 1, j, time + 1});
        }
        if (inArea(grid, i, j + 1) && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            queue.add(new int[] {i, j + 1, time + 1});
        }
        if (inArea(grid, i, j - 1) && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            queue.add(new int[] {i, j - 1, time + 1});
        }
    }

    private boolean inArea(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

}
