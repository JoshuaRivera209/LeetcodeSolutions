/*
   Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
   Notice that the solution set must not contain duplicate triplets.

   Example 1:
       Input: nums = [-1,0,1,2,-1,-4]
       Output: [[-1,-1,2],[-1,0,1]]
       Explanation:
       nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
       nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
       nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
       The distinct triplets are [-1,0,1] and [-1,-1,2].
       Notice that the order of the output and the order of the triplets does not matter.

   Example 2:
       Input: nums = [0,1,1]
       Output: []
       Explanation: The only possible triplet does not sum up to 0.

   Example 3:
       Input: nums = [0,0,0]
       Output: [[0,0,0]]
       Explanation: The only possible triplet sums up to 0.

   Constraints:
       3 <= nums.length <= 3000
       -105 <= nums[i] <= 105
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum_15 {
    // Method to find and return solution
    public static List<List<Integer>> threeSum(int[] nums) {
        /*
            My approach to this problem revolves around recreating 2sum II. We can do this
            by storing the first value in a variable, and only considering the rest of the array.
            We must also consider the constraint that no two indexes can equal one another, and the triplet
            must be unique. This would mean that i != j != k. We only return triplets that evaluate to 0, and
            we return the values that equal this. NOT the indices of those values.

            We will first sort the array, and iterate through it using a for loop to store the first variable of
            each iteration. We will then use the remainder of the sorted array to essentially perform 2sum II,
            where the target is fixed at 0 throughout runtime. Sorting the array and skipping duplicate numbers
            will allow us to avoid adding duplicate triplets to our result array. The expected runtime for this
            approach is O(n^2), with a space complexity of O(1)(?).
         */
        // We can check the minimum case where there is only 3 values in nums.
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                List<List<Integer>> output = new ArrayList<>(List.of(Arrays.stream(nums).boxed().toList()));
                return output;
            } else {
                return new ArrayList<>();
            }
        }
        // Otherwise we can continue normally
        List<List<Integer>> res = new ArrayList<>();
        // Sorting will add O(nlogn) runtime.
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            // If the value at i > 0 then we know that there are no more possible combinations
            // because we have gone through all negative values. So we can exit the loop.
            if (nums[i] > 0) break;
            // Otherwise we need to make sure we are not at a duplicate and handle accordingly.
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // Now we can break the problem down and perform 2sum II.
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                int curSum = nums[i] + nums[l] + nums[r];
                if (curSum < 0) {
                    l++;
                } else if (curSum > 0) {
                    r--;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[l], nums[r]);
                    res.add(triplet);
                    // Once we add a triplet we want to move our pointers to make sure they are not evaluated again.
                    l++;
                    /*
                        We use this while loop to skip duplicates on the left side. The reason we
                        do not care for the right side is because when our sum evaluates it will
                        adjust our right pointer for us.
                     */
                    while (l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
    // Main method to run program
    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
