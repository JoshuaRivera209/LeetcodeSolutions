/*
    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
    You must write an algorithm that runs in O(n) time.

    Example 1:
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

    Example 2:
    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9

    Constraints:
        0 <= nums.length <= 105
        -109 <= nums[i] <= 109
 */

import java.util.*;

public class longestConsecutiveSequence_128 {
    // Method to find and return number equivalent to longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        /*
            We will try a hashset approach for this problem. Since it has to be written in
            O(n) time, we will use a hashset and insert the array of numbers into it. Then, we will iterate
            through the array and check if the current number's *previous* number exists which will
            tell us if a sequence is forming. If the previous number does *not* exist, then we know that the current number is the beginning of a sequence.
            We will then count up, starting from this number and increment a counter to keep track of the longest sequence possible.
            Once we reach a number that is not in the array, we will compare this with the current longest value and update it accordingly. Then we will return this value at the end of the loop.
         */
        // First cover an edge case where our nums.length == 0
        if (nums.length == 0) {
            return 0;
        }
        // Initialize our hashset and add all the values to it
        HashSet<Integer> numSet = new HashSet<>();
        for (int i=0; i<nums.length;i++) {
            numSet.add(nums[i]);
        }
        /*
            Note: We use a hashset for this problem because we are counting a sequence of unique, consecutive numbers.
            We want to disregard any duplicates which a hashset automatically takes care of for us.
         */
        // Initialize counter and iterate through hashset to find the longest sequence.
        int maxCount = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num-1)) {
                int count = 1;
                while (numSet.contains(num + count)) {
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

    // Testing method
    public static void sortAndPrint(int[] nums) {
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        Collections.sort(numsList);
        System.out.println(numsList);
    }
    // Main method to run program
    public static void main(String[] args) {
        int[] test = new int[] {9,1,4,7,3,-1,0,5,8,-1,6};
        sortAndPrint(test);
        System.out.println(longestConsecutive(test));
    }
}
