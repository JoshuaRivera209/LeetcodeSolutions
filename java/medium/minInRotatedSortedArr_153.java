/*
    Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.
    Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
    Given the sorted rotated array nums of unique elements, return the minimum element of this array.
    You must write an algorithm that runs in O(log n) time.

    Example 1:
        Input: nums = [3,4,5,1,2]
        Output: 1
        Explanation: The original array was [1,2,3,4,5] rotated 3 times.

    Example 2:
        Input: nums = [4,5,6,7,0,1,2]
        Output: 0
        Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

    Example 3:
        Input: nums = [11,13,15,17]
        Output: 11
        Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

    Constraints:
        n == nums.length
        1 <= n <= 5000
        -5000 <= nums[i] <= 5000
        All the integers of nums are unique.
        nums is sorted and rotated between 1 and n times.
 */

public class minInRotatedSortedArr_153 {
    // method to find and return the minimum in the input array
    public static int findMin(int[] nums) {
        /*
            MY INITIAL APPROACH:
                Since we know that the array is sorted, we can perform a binary search.
                However, this will have a twist because the array will be rotated. With the array being rotated,
                we know there will be a point in the array where the max is a position behind the minimum. This essentially
                breaks the array into 2 ascending subarrays. It is possible to search for the minimum by finding the max and
                then taking the position in front of it. Between the left, right and middle pointers, 2 of them will belong to the
                same subarray. What we can do is compare the subarrays and consider the conditions of nums[l] < nums[mid] and nums[mid] < nums[r].
                If the first condition is true, then we know that the minimum is in the right side, and if the 2nd condition is true then we know that
                the minimum is in the left side.
         */
        int l=0; int r=nums.length-1;
        int res = nums[0];
        while(l<=r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int mid = l + (r-l)/2;
            res = Math.min(res, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    // main method to run program
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums2 = {3,4,5,1,2};
        int[] nums3 = {11,13,15,17};
        int[] nums4 = {1,2,3,4,5,6,7,8};
        System.out.println(findMin(nums));
    }
}
