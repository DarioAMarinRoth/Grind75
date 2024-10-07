package daily;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    private final List<int[]> events;

    public MyCalendarTwo() {
        this.events = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        int[] newEvent = new int[2];
        newEvent[0] = start;
        newEvent[1] = end;

        List<int[]> overlappingEvents = new ArrayList<>();

        for (int[] event : events) {
            if (event[0] < newEvent[1] && newEvent[0] < event[1]) {
                overlappingEvents.add(event);
            }
        }

        for (int i = 0; i < overlappingEvents.size(); i++) {
            for (int j = i + 1; j < overlappingEvents.size(); j++) {
                if (overlappingEvents.get(i)[0] < overlappingEvents.get(j)[1] && overlappingEvents.get(j)[0] < overlappingEvents.get(i)[1]) {
                    return false;
                }
            }
        }

        events.add(newEvent);
        return true;
    }
}
