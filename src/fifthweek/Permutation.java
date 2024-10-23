package fifthweek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    public static void main(String[] args) {
        System.out.println(new Permutation().permute(new int[] {1, 2, 3}));
    }

    private Set<List<Integer>> permutations;
    private List<Integer> currentPermutation;

    public List<List<Integer>> permute(int[] nums) {
        permutations = new HashSet<>();
        currentPermutation = new ArrayList<>();
        findPermutations(nums);
        return new ArrayList<>(permutations);
    }

    private void findPermutations(int[] nums) {
        for (int number : nums) {
            if (!currentPermutation.contains(number)) {
                currentPermutation.add(number);
                if (currentPermutation.size() == nums.length) {
                    ArrayList<Integer> aux = new ArrayList<>(currentPermutation);
                    permutations.add(aux);
                    currentPermutation.removeLast();
                } else {
                    findPermutations(nums);
                }
            }
        }
        if (!currentPermutation.isEmpty()) {
            currentPermutation.removeLast();
        }
    }
}
