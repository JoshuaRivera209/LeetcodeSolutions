/*
    You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
    Evaluate the expression. Return an integer that represents the value of the expression.

    Note that:
        The valid operators are '+', '-', '*', and '/'.
        Each operand may be an integer or another expression.
        The division between two integers always truncates toward zero.
        There will not be any division by zero.
        The input represents a valid arithmetic expression in a reverse polish notation.
        The answer and all the intermediate calculations can be represented in a 32-bit integer.

    Example 1:
        Input: tokens = ["2","1","+","3","*"]
        Output: 9
        Explanation: ((2 + 1) * 3) = 9

    Example 2:
        Input: tokens = ["4","13","5","/","+"]
        Output: 6
        Explanation: (4 + (13 / 5)) = 6

    Example 3:
        Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        Output: 22
        Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        = ((10 * (6 / (12 * -11))) + 17) + 5
        = ((10 * (6 / -132)) + 17) + 5
        = ((10 * 0) + 17) + 5
        = (0 + 17) + 5
        = 17 + 5
        = 22

    Constraints:
        1 <= tokens.length <= 104
        tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */

import java.util.Stack;

public class evalReversePolishNotation_150 {
    // Method to evaluate reverse polish notation expression
    public static int evalRPN (String[] tokens) {
        /*
            This approach will require the use of a stack. We will loop through the array,
            pushing values to the stack until we reach an operator (+, -, *, /). Once we reach an operator,
            we will pop the previous 2 values from the stack and perform the operation on the values, with the 2nd value
            that is popped being the first number, and first value popped being 2nd number. This will avoid any arithmetic errors
            when doing division. We then push this value back onto the stack and continue the loop until we reach another operator.
            This should always in theory result in 1 value left in the stack, which we can then return after the loop exits.
            This solution is in O(n) time complexity with a space complexity of O(n).
         */
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            // We check if the current position is an operator and push values onto the stack until we find one.
            /*
                Note: Because we know the input will always represent a valid expression, we do not need to consider a case
                where the 0 or 1 position of the array is an operator. This is because you always need 2 values to perform
                an operation.
             */
            if (!tokens[i].equals("*") && !tokens[i].equals("/") && !tokens[i].equals("+") && !tokens[i].equals("-")) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                // By this time we will always have at least 2 values in the stack, so we can safely pop 2 values
                // and store them in variables for an operation. Then we will push it back onto the stack.
                /*
                    Note: Because stack is a FILO data structure, the *2nd* number that is popped will be the number
                    on the left hand side of the expression.
                 */
                int num2 = stack.pop();
                int num1 = stack.pop();
                // Now we can set up a switch statement to perform the correct operation.
                switch (tokens[i]) {
                    case "*" -> stack.push(num1 * num2);
                    case "/" -> stack.push(num1 / num2);
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num1 - num2);
                }
            }
        }
        // In theory if executed properly, the stack should only have 1 value in it by the end of the loop
        // which is the result. We can return this.
        return stack.pop();
    }
    // Main method to run program
    public static void main(String[] args) {
        String[] tokens = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
