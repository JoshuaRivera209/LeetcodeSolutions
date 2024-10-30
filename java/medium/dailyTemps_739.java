/*
    Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

    Example 1:
        Input: temperatures = [73,74,75,71,69,72,76,73]
        Output: [1,1,4,2,1,1,0,0]

    Example 2:
        Input: temperatures = [30,40,50,60]
        Output: [1,1,1,0]

    Example 3:
        Input: temperatures = [30,60,90]
        Output: [1,1,0]

    Constraints:
        1 <= temperatures.length <= 105
        30 <= temperatures[i] <= 100
 */


import java.util.Arrays;
import java.util.Stack;

public class dailyTemps_739 {
    // Method to return output
    public static int[] dailyTemperatures(int[] temperatures) {
        /*
            This approach will use a monotonic decreasing stack. We will have a pair
            of values [temperature, index] that will go into the stack as an array and will be popped under
            2 conditions: the stack is not empty, or the current temperature > temperatures at
            the top of the stack. This will ensure that the temperatures in the stack
            maintain a decreasing order. We will have a result array with all values initialized to
            0 (this is default in java) and will take the difference between indices when we reach a temperature
            that is greater than the temperature at the top of the stack and replace the index at the lower temp
            in the result array with this difference after it is popped. The lower value from the stack will be popped to make way for
            the new high value. This solution is in linear time: O(n) and has a space complexity of O(n).
         */
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // stack will have [temperature, index]
        for (int i=0; i<temperatures.length; i++) {
            int currTemp = temperatures[i];
            while (!stack.isEmpty() && currTemp > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[] {currTemp, i});
        }
        return res;
    }
    // Main method to run program
    public static void main(String[] args) {
        int[] temps = new int[] {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temps)));
    }
}
