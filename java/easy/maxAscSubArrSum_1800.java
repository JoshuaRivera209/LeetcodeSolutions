/*
    Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
    A subarray is defined as a contiguous sequence of numbers in an array.
    A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.

    Example 1:
        Input: nums = [10,20,30,5,10,50]
        Output: 65
        Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.

    Example 2:
        Input: nums = [10,20,30,40,50]
        Output: 150
        Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.

    Example 3:
        Input: nums = [12,17,15,13,10,11,12]
        Output: 33
        Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.

    Constraints:
        1 <= nums.length <= 100
        1 <= nums[i] <= 100
 */

public class maxAscSubArrSum_1800 {
    // Method to compute and return result
    public static int maxAscendingSum(int[] nums) {
        /*
            The approach to this problem involves the use of a simple for loop (or while loop if you so choose).
            We will loop through the nums array up to nums.length-1 to avoid going out of bounds, and while we are doing
            that we will tally a sum until nums[i+1] <= nums[i]. Once we satisfy the condition we know the subarray is no longer
            ascending and can use Math.max() to compare the currentSum with the currentResult. We must also put a check for when
            we reach the 2nd to last value in the array because there is a case where this value is still ascending, so we must
            make sure to add it if the last value in the array is ascending still. The reason we do this check is because our upper
            bound is nums.length-1. Since we are performing operations within the array and not storing any
            large values in a data structure, the space complexity is a nice O(1) and the time complexity is O(n). This is
            the fastest time possible for this problem because we must scan the whole array for every possible sum.
         */
        // Cover edge case where nums.length == 1
        if (nums.length == 1) return nums[0];
        int res = 0;
        int currSum = 0;
        // Upper bound is nums.length-1 because we are checking r+1, so the last value we loop to should be the 2nd to last.
        // This will avoid any out of bounds errors.
        for (int r = 0; r < nums.length-1; r++) {
            currSum += nums[r];
            if (nums[r+1] <= nums[r]) {
                res = Math.max(res, currSum);
                currSum = 0;
            }
            if ((r+1) == nums.length-1 && nums[r+1] >= nums[r]) {
                currSum += nums[r+1];
                res = Math.max(res, currSum);
            }
        }
        return res;
    }

    // Main method to run program
    public static void main(String[] args) {
        int[] nums = new int[] {3,6,10,1,8,9,9,8,9};
        System.out.println(maxAscendingSum(nums));
    }
}
