package fifthweek;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int i = 0;
        int k = 0;
        int j = nums.length - 1;

        while (j > i && k <= j) {

            while (nums[i] == 0) {
                i++;
                while (k <= i) {
                    k++;
                }
            }
            while (nums[j] == 2) {
                j--;
            }

            if (j < i || k > j) {
                break;
            }

            if (nums[i] > nums[j]) {
                int aux = nums[i];
                nums[i] = nums[j];
                nums[j] = aux;
                k++;
                continue;
            }

            if (nums[k] == 0) {
                nums[k] = nums[i];
                nums[i] = 0;
                i++;
            } else if (nums[k] == 2) {
                nums[k] = nums[j];
                nums[j] = 2;
                j--;
            }
            k++;
        }
    }
}
