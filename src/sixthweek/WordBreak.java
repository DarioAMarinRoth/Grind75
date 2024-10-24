package sixthweek;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    private Map<String, Boolean> map = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean impossible = true;
        for (String word : wordDict) {
            if (s.endsWith(word)) {
                impossible = false;
                break;
            }
        }
        if (impossible) {
            return false;
        }
        return task(s, wordDict);
    }

    private boolean task(String s, List<String> wordDict) {

        if (map.containsKey(s)) {
            return false;
        }

        for (String word : wordDict) {
            String save = s;
            if (s.startsWith(word)) {
                if (s.length() == word.length()) {
                    return true;
                }
                s = s.substring(word.length());
                if (wordBreak(s, wordDict)) {
                    return true;
                }
                s = save;
            }
        }
        map.put(s, false);
        return false;
    }
}
