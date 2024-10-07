package daily;

import java.util.*;

public class MyCircularDeque {

    private final int maxSize;
    private List<Integer> list;

    public MyCircularDeque(int k) {
        maxSize = k;
        list = new ArrayList<>(k);
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            list.addFirst(value);
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            list.addLast(value);
            return true;
        }
    }

    public boolean deleteFront() {
        if (!isEmpty()) {
            list.removeFirst();
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteLast() {
        if (!isEmpty()) {
            list.removeLast();
            return true;
        } else {
            return false;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return list.getFirst();
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return list.getLast();
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == maxSize;
    }
}
