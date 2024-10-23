package fifthweek;

import java.util.*;

public class CombinationSum {

    private List<Integer> currentCombination;
    Set<List<Integer>> combinations;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations = new HashSet<>();
        currentCombination = new ArrayList<>();
        findCombinations(candidates, target);
        return new ArrayList<>(combinations);
    }

    private void findCombinations(int[] candidates, int target) {

        for (int candidate : candidates) {
            if (candidate < target) {
                currentCombination.add(candidate);
                findCombinations(candidates, target - candidate);
            } else if (candidate == target) {
                List<Integer> aux = new ArrayList<>(currentCombination);
                aux.add(candidate);
                Collections.sort(aux);
                combinations.add(aux);
            }
        }
        if (!currentCombination.isEmpty()){
            currentCombination.removeLast();
        }
    }
}
