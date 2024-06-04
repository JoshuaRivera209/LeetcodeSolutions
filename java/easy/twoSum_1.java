/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.



    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
 */


import java.util.Arrays;
import java.util.HashMap;

public class twoSum_1 {
    // Brute force solution to calculate indices of values that add up to target
    public static void twoSumBruteForce(int[] nums, int target) {
        // Starting with brute force approach, will refactor and improve
        int[] result = new int[2];
        for (int i=0; i<nums.length;i++) {
            for (int j=0; j<nums.length;j++) {
                if (nums[i]+nums[j]==target) {
                    result[0] = i;
                    result[1] = j;
                    System.out.println(Arrays.toString(result));
                    return;
                }
            }
        }
    }

    // Optimized solution to calculate indices of values that add up to target
    public static int[] twoSumOptimized(int[] nums, int target) {
        // Using a hashmap we will add the complimentary number as a key
        // and current index as value
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        for (int i=0; i<nums.length;i++) {
            // If the key is already in the hashmap then we have found a solution
            if (numsMap.containsKey(nums[i])) {
                return new int[] {numsMap.get(nums[i]), i};
            // Otherwise we add the complimentary number and the index to the hashmap
            } else {
                numsMap.put(target - nums[i], i);
            }
        }
        return null;
    }

    // Main driver function of solution
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
//        twoSum(nums, target);
        System.out.println(Arrays.toString(twoSumOptimized(nums, target)));
    }
}
