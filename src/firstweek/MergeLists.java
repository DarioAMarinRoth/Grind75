package firstweek;

import util.ListNode;

public class MergeLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode next;
        ListNode mergeList;

        if (list1 != null || list2 != null) {
            next = new ListNode();
            if (list1 == null) {
                next.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                next.val = list1.val;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                next.val = list1.val;
                list1 = list1.next;
            } else {
                next.val = list2.val;
                list2 = list2.next;
            }
        } else {
            next = null;
        }

        mergeList = next;

        while (list1 != null || list2 != null) {
            next.next = new ListNode();
            next = next.next;

            if (list1 == null) {
                next.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                next.val = list1.val;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                next.val = list1.val;
                list1 = list1.next;
            } else {
                next.val = list2.val;
                list2 = list2.next;
            }
        }
        return mergeList;
    }
}
