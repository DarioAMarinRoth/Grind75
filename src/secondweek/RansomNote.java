package secondweek;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> letters = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (!letters.containsKey(magazine.charAt(i))) {
                letters.put(magazine.charAt(i), 1);
            } else {
                letters.put(magazine.charAt(i), letters.get(magazine.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!letters.containsKey(ransomNote.charAt(i))) {
                return false;
            } else {
                letters.put(ransomNote.charAt(i), letters.get(ransomNote.charAt(i)) - 1);
                if (letters.get(ransomNote.charAt(i)) == 0) {
                    letters.remove(ransomNote.charAt(i));
                }
            }
        }
        return true;
    }
}
