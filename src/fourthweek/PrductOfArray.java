package fourthweek;

public class PrductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int zeroes = 0;
        long product = 1;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
                j = i;
                continue;
            }
            product *= nums[i];
        }

        int[] products = new int[nums.length];

        switch (zeroes) {
            case 0 -> {
                for (int i = 0; i < products.length; i++) {
                    products[i] = (int) (product / nums[i]);
                }
            }
            case 1 -> {
                products[j] = (int) product;
            }
        }


        return products;
    }
}
