/*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:
        Input: n = 3
        Output: ["((()))","(()())","(())()","()(())","()()()"]

    Example 2:
        Input: n = 1
        Output: ["()"]

    Constraints:
        1 <= n <= 8
 */

import java.util.ArrayList;
import java.util.List;

public class genParentheses_22 {
    // Function that will generate permutations of parentheses using backtracking
    public static void backtracking(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        /*
            The approach for this problem will require the use of recursion and backtracking. We will use
            2 counters (openN, closedN) to determine when we can appropriately open and close sets of parentheses.
            With the given number n, we know that there will be n*2 characters in the string because parentheses come in pairs "()".
            We increment the open/close counters each time we add a parentheses, and will make sure that openN > closedN to ensure that
            the generated parentheses are valid. We will know that the parentheses generation is done when openN == closedN == n. From here
            we will then add the valid parentheses to our StringBuilder and return. Since we are using recursion, there will be function calls
            inside the backtracking function to continue generating parentheses. The time complexity of this problem is quite interesting,
            with it being O(4^n / sqrt(n)) and the space complexity being O(n).
         */
        // Base case to exit function
        if (openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }
        // Add open parentheses if appropriate, and remove character after adding it.
        // We do this because we must pass in the StringBuilder with our function calls, and we do not want to interfere with it.
        if (openN < n) {
            stack.append('(');
            backtracking(openN+1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length()-1);
        }
        // Add closed parentheses if appropriate, and remove character after adding it.
        if (closedN < openN) {
            stack.append(')');
            backtracking(openN, closedN+1, n, res, stack);
            stack.deleteCharAt(stack.length()-1);
        }
    }

    // Function that will return the list of generated parentheses
    public static List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtracking(0, 0, n, res, stack);
        return res;
    }

    // Main function that will enable program to run
    public static void main(String[] args) {

    }
}
