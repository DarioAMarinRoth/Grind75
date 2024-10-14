package fourthweek;

import java.util.ArrayDeque;
import java.util.Queue;

public class Islands {

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Islands islands = new Islands();
        System.out.println(islands.numIslands(grid));
    }


    public int numIslands(char[][] grid) {

        int height = grid.length;
        int width = grid[0].length;
        int numIslands = 0;

        Queue<int[]> land = new ArrayDeque<>();
        boolean[][] visited = new boolean[height][width];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (visited[i][j]) {
                    continue;
                }

                if (grid[i][j] == '0') {
                    visited[i][j] = true;
                    continue;
                }

                land.add(new int[]{i, j});
                visited[i][j] = true;
                while (!land.isEmpty()) {
                    int[] cell = land.poll();

                    for (int[] dir : directions) {
                        int newI = cell[0] + dir[0];
                        int newJ = cell[1] + dir[1];

                        if (newI >= 0 && newI < height && newJ >= 0 && newJ < width && !visited[newI][newJ]) {
                            if (grid[newI][newJ] == '1') {
                                land.add(new int[]{newI, newJ});
                            }
                            visited[newI][newJ] = true;
                        }
                    }
                }
                numIslands++;
            }
        }
        return numIslands;
    }
}
