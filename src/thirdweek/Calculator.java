package thirdweek;

import java.util.Stack;

public class Calculator {

    public static void main(String[] args) {
        String[] token = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Calculator calculator = new Calculator();
        System.out.println(calculator.evalRPN(token));
    }

    public int evalRPN(String[] token) {
        Stack<Integer> numbers = new Stack<>();

        for (String element : token) {
            switch (element) {
                case "+" -> {
                    numbers.add(numbers.pop() + numbers.pop());
                }
                case "-" -> {
                    int right = numbers.pop();
                    int left = numbers.pop();
                    numbers.add(left - right);
                }
                case "*" -> {
                    numbers.add(numbers.pop() * numbers.pop());
                }
                case "/" -> {
                    int right = numbers.pop();
                    int left = numbers.pop();
                    numbers.add(left / right);
                }
                default -> {
                    numbers.add(Integer.parseInt(element));
                }
            }
        }

        return numbers.pop();
    }
}
