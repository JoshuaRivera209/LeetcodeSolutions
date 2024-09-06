/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

    Example 1:

    Input: s = "()"
    Output: true

    Example 2:

    Input: s = "()[]{}"
    Output: true

    Example 3:

    Input: s = "(]"
    Output: false

    Constraints:
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

*/

import java.util.Stack;

public class validParentheses_20 {
    public static boolean isValid(String s) {
        // If stack size is odd then there is an extra parentheses
        if(s.length() % 2 > 0){
            return false;
        }
        // Otherwise continue as normal, initialize stack
        Stack<String> stringStack = new Stack<>();
        // Loop through string to check validity
        for (int i=0; i<s.length(); i++) {
            // Set current character to string to avoid type errors
            String charString = String.valueOf(s.charAt(i));
            // Check if parentheses is opening or closing
            if(charString.equals("(") || charString.equals("{") || charString.equals("[")) {
                // For the sake of simplicity we only push open parentheses,
                // and will check a case if closing is the first character
                stringStack.push(charString);
              // Based on constraints, there are only open/close parentheses
              // which is why if/else is usable here
            } else {
                // If we are at a closing parentheses in the beginning or stack is empty,
                // then string is invalid. Exit
                if(i==0 || stringStack.size() == 0) {
                    return false;
                }
                //Otherwise we enter switch statement
                switch (charString) {
                    // If the matching parentheses is at the top of the stack,
                    // pop it off and continue for-loop, otherwise there is a mismatch.
                    // Return false and terminate program
                    case ")" -> {
                        if (stringStack.peek().equals("(")) {
                            stringStack.pop();
                        } else return false;
                    }
                    case "}" -> {
                        if (stringStack.peek().equals("{")) {
                            stringStack.pop();
                        } else return false;
                    }
                    case "]" -> {
                        if (stringStack.peek().equals("[")) {
                            stringStack.pop();
                        } else return false;
                    }
                }
            }
        }
        // If we exit the for loop and the stack is not empty,
        // then a parentheses was not closed. We return false and exit.
        // Otherwise, if the stack is empty then the string is valid and return true.
        if(stringStack.size() != 0) {
            return false;
        } else return true;
    }
    public static void main(String[] args) {
        String s = "((";
        String s2 = "(){}}{";
        System.out.println(isValid(s2));
    }
}
