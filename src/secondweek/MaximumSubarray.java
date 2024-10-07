package secondweek;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int maxSum = nums[0];

        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}
