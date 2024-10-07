package secondweek;

import util.ListNode;

import java.util.Stack;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        Stack<ListNode> aux = new Stack<>();

        while (head != null) {
            aux.push(head);
            head = head.next;
        }

        ListNode next = aux.pop();
        ListNode reversedList = next;
        while (!aux.empty()) {
            next.next = aux.pop();
            next = next.next;
        }

        next.next = null;
        return reversedList;
    }
}
