package secondweek;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    public int longestPalindrome(String s) {

        Map<Character, Integer> occurrences = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (occurrences.containsKey(c)) {
                occurrences.replace(c, occurrences.get(c) + 1);
            } else {
                occurrences.put(c, 1);
            }
        }

        Set<Character> chars = occurrences.keySet();
        int length = 0;
        int maxOdd = 1;
        boolean odd = false;
        for (Character c : chars) {
            length += occurrences.get(c);
            if (occurrences.get(c) % 2 == 1) {
                odd = true;
                length -= 1;
            }
        }
        if (odd) {
            length += 1;
        }
        return length;
    }

    public int longestPalindrome2(String s) {

        int length = 0;
        Map<Character,Integer> letters = new HashMap<>();
        char letter;
        int temp;
        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);
            if (letters.containsKey(letter)) {
                temp = letters.get(letter) + 1;
                if (temp == 2) {
                    length += 2;
                    letters.replace(letter, 0);
                }
            } else {
                letters.put(letter, 1);
            }
        }
        if (letters.containsValue(1)) {
            return length + 1;
        }
        return length;
    }

    public int longestPalindrome3(String s) {

        boolean odd = false;
        int length = 0;
        Set<Character> lettets = new HashSet<>();

        for (int i = 0, sum = 0; i < s.length(); i++) {
            sum = 0;
            if (lettets.contains(s.charAt(i))) {
                continue;
            }
            lettets.add(s.charAt(i));
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    sum++;
                }
            }
            if (sum % 2 == 0) {
                length += sum;
            } else {
                length += sum -1;
                odd = true;
            }
        }

        if (odd) {
            length += 1;
        }

        return length;
    }
}
