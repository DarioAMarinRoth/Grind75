package thirdweek;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        int[][] updatedMat = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                updatedMat[i][j] = calculateDistance(mat, i, j);
            }
        }
        return updatedMat;
    }

    private int calculateDistance(int[][] matrix, int row, int col) {

        if (matrix[row][col] == 0) {
            return 0;
        }

        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    distance = Math.min(distance, Math.abs(row - i) + Math.abs(col - j));
                }
            }
        }
        return distance;
    }


    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        Matrix01 m = new Matrix01();
        m.bfs(mat);
    }


    private int[][] bfs(int[][] mat) {

        Queue<int[]> queue = new LinkedList<>();
        int nRows = mat.length;
        int nCols = mat[0].length;

        boolean[][] visited = new boolean[nRows][nCols];
        int[][] distance = new int[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {

            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int d = node[2];

            visited[i][j] = true;
            distance[i][j] = d;

            for (int[] dir : directions) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI >= 0 && newI < nRows && newJ >= 0 && newJ < nCols && !visited[newI][newJ]) {
                    queue.add(new int[]{newI, newJ, d + 1});
                    visited[newI][newJ] = true;
                }
            }
        }

        return distance;
    }

}
