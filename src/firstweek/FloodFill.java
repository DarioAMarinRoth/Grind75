package firstweek;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];

        if (target == color) {
            return image;
        }

        expand(image, sr, sc, target, color);
        return image;
    }

    private void expand(int[][] image, int sr, int sc, int target, int color) {

        if ( sr >= image.length || sr < 0 || sc >= image[sr].length || sc < 0 ) {
            return;
        }
        if (image[sr][sc] != target) {
            return;
        }

        image[sr][sc] = color;

        expand(image, sr + 1, sc, target, color);
        expand(image, sr - 1, sc, target, color);
        expand(image, sr, sc + 1, target, color);
        expand(image, sr, sc - 1, target, color);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%3d", element);
            }
            System.out.println();
        }
    }
}
