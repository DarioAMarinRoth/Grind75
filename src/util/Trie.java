package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie {

    private final Map<Character, Trie> nextChars;
    private final Set<String> words;

    public Trie() {
        words = new HashSet<>();
        nextChars = new HashMap<>();
    }

    public void insert(String word) {
        words.add(word);
        Trie aux = this;
        char c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (!aux.nextChars.containsKey(c)) {
                aux.nextChars.put(c, new Trie());
            }
            aux = aux.nextChars.get(c);
        }
    }

    public boolean search(String word) {
        return words.contains(word);
    }

    public boolean startsWith(String prefix) {
        Trie aux = this;
        char c;
        for (int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            if (!aux.nextChars.containsKey(c)) {
                return false;
            }
            aux = aux.nextChars.get(c);
        }
        return true;
    }
}
