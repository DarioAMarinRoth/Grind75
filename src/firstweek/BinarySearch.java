package firstweek;

public class BinarySearch {

    public static <tipo> void imprimirVector(tipo[] vector) {
        for (var e : vector) {
            System.out.println(e);
        }
    }
    public int search(int[] nums, int target) {

        int maxIndex = nums.length;
        int minIndex = 0;
        int index = maxIndex / 2;
        int i = 0;

        while (nums[index] != target && i < nums.length / 2) {
            if (nums[index] > target) {
                maxIndex = index;
            } else {
                minIndex = index;
            }
            index = (maxIndex + minIndex) / 2;
            i++;
        }

        if (i >= nums.length / 2) {
            return -1;
        } else {
            return index;
        }
    }
}
