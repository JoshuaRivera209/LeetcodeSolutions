/*
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [1,3,5,6], target = 5
    Output: 2

    Example 2:
    Input: nums = [1,3,5,6], target = 2
    Output: 1

    Example 3:
    Input: nums = [1,3,5,6], target = 7
    Output: 4

    Constraints:
        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums contains distinct values sorted in ascending order.
        -104 <= target <= 104
 */


public class searchInsertPosition_35 {
    // Method to find the position and return it
    public static int searchInsert(int[] nums, int target) {
        // Since we know the array is sorted, and we need to write an algorithm
        // with O(log n) runtime complexity we know we need to implement binary search.
        // This is because binary search has a time complexity of O(log n).

        // Initialize variables for binary search
        int left = 0;
        int right = nums.length-1;
        // We must return the INDEX of the number if the target is found.
        // Otherwise we return where the number would belong in the array.
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target ) {
                return middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        // We return the left index because the left must cross over the right to
        // exit the while loop. This would mean that if the target doesn't exist,
        // the left index will the place where the target *should* exist.
        return left;
    }

    // Main method to run program
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
