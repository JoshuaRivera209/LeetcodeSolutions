/*
    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
    If target exists, then return its index. Otherwise, return -1.
    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
        Input: nums = [-1,0,3,5,9,12], target = 9
        Output: 4
        Explanation: 9 exists in nums and its index is 4

    Example 2:
        Input: nums = [-1,0,3,5,9,12], target = 2
        Output: -1
        Explanation: 2 does not exist in nums so return -1

    Constraints:
        1 <= nums.length <= 104
        -104 < nums[i], target < 104
        All the integers in nums are unique.
        nums is sorted in ascending order.
 */

public class binarySearch_704 {
    // Method to find and return index of target value
    public static int search(int[] nums, int target) {
        /*
            This problem is a straight forward binary search problem. The idea behind binary search involves searching
            for a number (target) in a sorted array of numbers. Start with the middle value of the array as well as
            2 pointers at the beginning and the end of the array. Check if the middle value is equal to the target.
            If it is not, then we consider if it is less than or more than the target. If it is more than the target,
            then we know that the target must be on the left side of the array starting from the middle because the array
            is sorted. If it is less than the target, then we know that the target is on the right half of the array. Depending
            on which condition this falls under, we will reassign either the left or the right pointer to effectively eliminate
            the appropriate side of the array where the target is NOT located. i.e nums[middle] < target = we disregard left half
            of the array. The grand idea with this search algorithm is that we are essentially eliminating half of the data each time
            we check for the target, which makes the runtime a lot faster than traditionally searching for the target using a linear
            method. The drawback with this algorithm is that it only works when the array is sorted. The time complexity of this
            algorithm is O(log n) and space complexity is O(1) when optimized. You can also recursively perform a binary search
            but this will use O(n) memory because it utilizes the call stack.
         */
        // Initialize left and right pointers
        int l = 0;
        int r = nums.length - 1;
        // Create while loop with condition
        while (l<=r) {
            // We initialize mid in the while loop so it updates automatically as we update l and r
            // This will make it so we do not have to update mid manually
            int mid = l + (r-l) / 2;
            // Return the mid index if we find the target
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // If we exit the while loop it means we search the array and did not find the target value
        // so we can return -1
        return -1;
    }
    // Main method to run program
    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums, target));
    }
}
