/*
    Given an integer array nums of unique elements, return all possible
    subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.

    Example 1:
        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    Example 2:
        Input: nums = [0]
        Output: [[],[0]]

    Constraints:
        1 <= nums.length <= 10
        -10 <= nums[i] <= 10
        All the numbers of nums are unique.
 */

import java.util.ArrayList;
import java.util.List;

public class subsets_78 {
    // Method to generate and return all subsets for a given input
    public static List<List<Integer>> subsets(int[] nums) {
        /*
            This problem takes a backtracking approach with recursion. A DFS will be
            used to explore the possible subsets by deciding to add or to not add a number
            to the subset. When a dead end (end of array) is reached, we will append the current state of the subset and then
            *backtrack* to the earliest possible solution. We will compile these
            results into a List to have all the possible subsets, and then return this list. Since we have to make
            a decision at each step we are creating more possibilities, more specifically two possibilities at each step.
            This causes the runtime to grow exponentially based on the size of the input with a base of 2 because there are
            2 decisions made at each step (add or not add). This would make the time complexity 2^n. For the space complexity,
            because the result list is a part of the problem we do not consider this as a factor when thinking about the space
            complexity. We ARE performing recursion however, and recursion is known to take up a lot of memory because of its need
            to be stored within the call stack when making function calls. Because of this, the depth of our tree from our recursive
            DFS will be equal to the size of the array, thus leading us to a space complexity of O(n).
         */
        // Create result list
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    // Helper method to run dfs, generate subsets, and add them to result list
    public static void dfs(int[] nums, int pos, List<Integer> subset, List<List<Integer>> res) {
        // Base case for recursion
        if (pos >= nums.length) {
            // if we are out of bounds we can add the current subarray to the list of results and exit
            res.add(new ArrayList<>(subset));
            return;
        }
        // Call dfs when we choose to add the number to the subset
        subset.add(nums[pos]);
        dfs(nums, pos+1, subset, res);
        // Remove the number so we can call dfs when we choose *not* to add the number to the subset
        subset.remove(subset.size() - 1);
        // Call dfs when we choose *not* to add number to subset
        dfs(nums, pos+1, subset, res);
    }


    // Main method to run program
    public static void main(String[] args) {

    }
}
