package fifthweek;

import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        System.out.println(new Search().search(nums,0));
    }
    public int search(int[] nums, int target) {
        int pivot = nums.length - 1;
        if (nums[0] > nums[nums.length - 1]) {
             pivot = findPivot(nums);
        }

        if (target > nums[pivot]) {
            return -1;
        }

        int left;
        int right;
        if (target >= nums[0]) {
            left = 0;
            right = pivot;
        } else {
            left = pivot + 1;
            right = nums.length - 1;
        }

        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }


        return -1;
    }

    private int findPivot(int[] nums) {
        int k;
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            k = (left + right) / 2;
            if (isAPivot(nums, k)) {
                return k;
            }
            if (nums[k] > nums[right]) {
                left = k;
            } else {
                right = k;
            }
        }
    }

    private boolean isAPivot(int[] nums, int k) {
        if (k == nums.length - 1) {
            return false;
        }
        return nums[k] > nums[k + 1];
    }
}
