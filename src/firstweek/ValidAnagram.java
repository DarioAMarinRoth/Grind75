package firstweek;


import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sLetters = new HashMap<>();
        Map<Character, Integer> tLetters = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            updateMap(sLetters,s.charAt(i));
            updateMap(tLetters,t.charAt(i));
        }

        return sLetters.equals(tLetters);
    }

    private void updateMap(Map<Character, Integer> map, char key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}
