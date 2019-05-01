package stack.validparatheses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * @author liuzhengyang
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put(')', '(');
        parentheses.put('}', '{');
        parentheses.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Character matched = parentheses.get(c);
            if (matched == null) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (!matched.equals(pop)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
