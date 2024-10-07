package daily;

import java.util.HashMap;
import java.util.Map;

public class AllOne {

    private String maxKey;
    private String minKey;
    private int maxCount;
    private int minCount;
    private final Map<String, Integer> counter;

    public AllOne() {
        counter = new HashMap<>();
        int maxCount = 0;
        int minCount = Integer.MAX_VALUE;
    }

    public void inc(String key) {
        int count;
        if (counter.containsKey(key)) {
            count = counter.get(key) + 1;
            counter.replace(key, count);
        } else {
            count = 1;
            counter.put(key, count);
        }

        if (count > maxCount) {
            maxCount = count;
            maxKey = key;
        }
    }

    public void dec(String key) {
        int count;
        if (counter.containsKey(key)) {
            count = counter.get(key) + 1;
            counter.replace(key, count);
        } else {
            count = 1;
            counter.put(key, count);
        }

        if (count > maxCount) {
            maxCount = count;
            maxKey = key;
        }
    }

}
