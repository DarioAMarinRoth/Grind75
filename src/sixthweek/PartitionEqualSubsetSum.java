package sixthweek;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {14,9,8,4,3,2}));
    }

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;


        Arrays.sort(nums);
        boolean sums[] = new boolean[target + 1];
        sums[0] = true;
        for (int num : nums) {
            for (int i = target; i >= 0; i++) {
                if (sums[i]) {
                    if (i + num == target) {
                        return true;
                    } if (i + num < target) {
                        sums[i + num] = true;
                    }
                }
            }
        }
        return false;
    }
}
