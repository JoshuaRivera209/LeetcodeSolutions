/*
    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    Example 1:

    Input: nums = [1,2,3,1]
    Output: true
    Example 2:

    Input: nums = [1,2,3,4]
    Output: false
    Example 3:

    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true


    Constraints:

    1 <= nums.length <= 105
    -109 <= nums[i] <= 109

 */

import java.util.HashMap;

public class containsDuplicate_217 {
    // Class to determine if there is a duplicate
    public static boolean containsDuplicate(int[] nums) {
        // Use hashmap to keep track of frequency of numbers
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        // We have to keep scanning the array until we reach a duplicate
        // If we reach the end then we know there are none
        // This is worst case and would be O(n)
        for (int i=0; i<nums.length; i++) {
            // If number doesn't exist in hashmap then we add it
            if(!numsMap.containsKey(nums[i])) {
                numsMap.put(nums[i], 1);
            } else {
                // Otherwise we know we've hit a duplicate and can exit
                return true;
            }
        }
        // We've reached the end, so we return false because all elements are distinct
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
