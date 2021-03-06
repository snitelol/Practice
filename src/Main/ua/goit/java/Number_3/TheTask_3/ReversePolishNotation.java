package Main.ua.goit.java.Number_3.TheTask_3;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by 7 on 14.05.2016.
 */
public class ReversePolishNotation {
    public static int evaluate(String expression) {
        ArrayList<String> list = new ArrayList<>();
        list.add("*");
        list.add("/");
        list.add("+");
        list.add("-");

        StringTokenizer tokenizer = new StringTokenizer(expression, " ");
        Stack<Integer> stack = new Stack<Integer>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!list.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                if (token.equals("*")) {
                    stack.push(operand1* operand2);
                } else if (token.equals("/")) {
                    stack.push(operand1 / operand2);
                } else if (token.equals("+")) {
                    stack.push(operand1 + operand2);
                } else if (token.equals("-")) {
                    stack.push(operand1 - operand2);
                }
            }
        }
        return Integer.parseInt(stack.pop().toString());
    }
}
