package secondweek;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int num : nums) {
            if (!values.add(num)) {
                return true;
            }
        }
        return false;
    }
}
