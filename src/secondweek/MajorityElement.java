package secondweek;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majorityElement = nums[0];
        Map<Integer, Integer> frecuence = new HashMap<>();
        for (int num : nums) {
            if (frecuence.containsKey(num)) {
                int temp = frecuence.get(num) + 1;
                frecuence.replace(num, temp);
                if (temp > frecuence.get(majorityElement)) {
                    majorityElement = num;
                }
            } else {
                frecuence.put(num, 1);
            }
        }

        return majorityElement;
    }
}
