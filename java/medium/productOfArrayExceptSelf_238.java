/*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

    Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]

    Constraints:
        2 <= nums.length <= 105
        -30 <= nums[i] <= 30
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */

import java.util.Arrays;

public class productOfArrayExceptSelf_238 {
    // Method to compute and return result
    public static int[] productExceptSelf(int[] nums) {
        // In order to utilize O(1) space, we will compute the pre/postfixes and keep
        // the values stored in the result array
        int[] result = new int[nums.length];
        // Since arrays are initialized with a default value of 0 in Java, we need to manually assign
        // values of 1 to each position in order to avoid multiplying by 0
        Arrays.fill(result, 1);
        // Prefix will start at 1
        int prefix = 1;
        // Iterate through nums to compute prefix values and store them in result array
        for (int i=0; i<nums.length; i++) {
            result[i] *= prefix;
            // Make sure to update prefix value in order to compute correct values
            prefix *= nums[i];
        }
        // Postfix will also start at 1
        int postfix = 1;
        // Once prefix values are computed, do the same for postfix values working backwards through result array
        for (int i=nums.length-1; i>=0; i--) {
            result[i] *= postfix;
            // Make sure to update postfix value in order to compute correct values
            postfix *= nums[i];
        }
        // Once we have computed all products we return the result
        return result;
    }

    // Main method to run program
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
