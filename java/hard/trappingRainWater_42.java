/*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

    Example 1:
        Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
        Output: 6
        Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:
        Input: height = [4,2,0,3,2,5]
        Output: 9

    Constraints:
        n == height.length
        1 <= n <= 2 * 104
        0 <= height[i] <= 105
 */

public class trappingRainWater_42 {
    // Method to find and return the amount of water that can be trapped after rain
    public static int trap(int[] height) {
        /*
            This problem involves a simple to write solution, but a deep
            understanding of the problem's complexity. We will use 2 pointers
            to keep track of the max height on both the left and the right, as
            well as a variable that will hold the running total of the amount of water
            that can be held. We will do this in just one pass of the array, and will
            take the max height from the left and the max height from the right.
            We will subtract the height of the current value from the maximum height on a
            given side, and this value will be added to our running total.

            When the value of the left height < value of right height, we will increment
            the left pointer. Otherwise we will decrement the right pointer. Then we will update
            the max height value by comparing the value at the new pointer value with the current
            max value. Since we are doing this in one pass without allocating new space for an array
            holding max values, this solution has a runtime complexity of O(n) and a space complexity of
            O(1).
         */
        // Handle edge case where the input array is empty
        if (height.length == 0) {
            return 0;
        }
        // Declare all variables needed to perform operations
        int res = 0;
        int l = 0;
        int r = height.length-1;
        int leftMax = height[l];
        int rightMax = height[r];
        // Loop to pass through array and calculate running total of
        // water that can be trapped.
        while(l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }

    // Main method to run program
    public static void main(String[] args) {
        int[] test = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(test));
    }
}
