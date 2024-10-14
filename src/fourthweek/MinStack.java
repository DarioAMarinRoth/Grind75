package fourthweek;

import java.util.*;

public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.add(val);
        }
    }

    public void pop() {
        int val  = stack.pop();
        if (val == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
