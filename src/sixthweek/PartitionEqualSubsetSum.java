package sixthweek;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {14,9,8,4,3,2}));
    }

    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        int reverseTotalSum = 0;

        Arrays.sort(nums);
        int[] cumulativeSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            cumulativeSum[i] = totalSum;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        for (int i = 0; i < cumulativeSum.length; i++) {
            if (cumulativeSum[i] == target) {
                return true;
            }
            for (int j = 0; j < cumulativeSum.length; j++) {
                if (i == j) {
                    continue;
                }
                if (cumulativeSum[i] - cumulativeSum[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
