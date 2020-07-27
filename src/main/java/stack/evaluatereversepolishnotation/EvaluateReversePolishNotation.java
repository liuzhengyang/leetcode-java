package stack.evaluatereversepolishnotation;

import java.util.Stack;
import java.util.function.BiFunction;

/**
 * @author liuzhengyang
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        for (String token : tokens) {
            BiFunction<Integer, Integer, Integer> biFunction = getBiFunction(token);
            if (biFunction == null) {
                number.push(Integer.parseInt(token));
            } else {
                Integer first = number.pop();
                Integer second = number.pop();
                Integer result = biFunction.apply(second, first);
                number.push(result);
            }
        }
        return number.pop();
    }

    private BiFunction<Integer, Integer, Integer> getBiFunction(String operator) {
        switch (operator) {
            case "+":
                return Integer::sum;
            case "-":
                return (a, b) -> a - b;
            case "*":
                return (a, b) -> a * b;
            case "/":
                return (a, b) -> a / b;
        }
        return null;
    }
}
