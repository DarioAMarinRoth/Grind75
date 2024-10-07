package secondweek;

import util.ListNode;

import java.util.Stack;



public class MiddleLinkedList {

    public ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        }

        Stack<ListNode> nodes = new Stack<>();
        int length = 0;

        while (head != null) {
            nodes.push(head);
            head = head.next;
            length++;
        }

        for (int i = 0; i < (length - 1) / 2; i++) {
            nodes.pop();
        }

        return nodes.peek();
    }

    public ListNode middleNode2(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
