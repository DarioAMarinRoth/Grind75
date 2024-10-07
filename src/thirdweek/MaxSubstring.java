package thirdweek;

import java.util.HashMap;
import java.util.Map;

public class MaxSubstring {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int length = 0;
        int maxLength = 0;
        char c;
        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            if (chars.containsKey(c)) {
                if (chars.get(c) < left) {
                    chars.replace(c, i);
                    length++;
                } else {
                    left = chars.get(c) + 1;
                    length = i - chars.get(c);
                    chars.replace(c, i);
                }
            } else {
                chars.put(c, i);
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}
