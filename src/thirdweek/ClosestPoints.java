package thirdweek;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class ClosestPoints {
    public int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points,new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int quadraticSumA = a[0] * a[0] + a[1] * a[1];
                int quadraticSumB = b[0] * b[0] + b[1] * b[1];
                return Integer.compare(quadraticSumA, quadraticSumB);
            }
        });

        return Arrays.copyOf(points, k);
    }
}
