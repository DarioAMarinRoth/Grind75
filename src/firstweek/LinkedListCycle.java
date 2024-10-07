package firstweek;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;


public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        List<ListNode> nodes = new ArrayList<>();
        nodes.add(head);
        ListNode next;

        while (head.next != null) {
            next = head.next;
            if (nodes.contains(next)) {
                return true;
            } else {
                nodes.add(next);
                head = next;
            }
        }
        return false;
    }


}
