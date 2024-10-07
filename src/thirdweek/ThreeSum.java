package thirdweek;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        System.out.println(ts.threeSum(new int[] {-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {

        Set<Integer> noRepeatedNums = new HashSet<>();
        Set<List<Integer>> usedCombinations = new HashSet<>();
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> aux;


        int opposite;
        int x;

        for (int i = 0; i < nums.length; i++) {
            opposite = -nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                x = opposite - nums[j];
                if (noRepeatedNums.contains(x)) {
                    aux = new ArrayList<>();
                    aux.add(nums[i]);
                    aux.add(nums[j]);
                    aux.add(x);
                    Collections.sort(aux);
                    if (usedCombinations.add(aux)){
                        combinations.add(aux);
                    }
                }
                noRepeatedNums.add(nums[j]);
            }
            noRepeatedNums.add(nums[i]);
        }

        return combinations;
    }
}

