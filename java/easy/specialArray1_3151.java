/*
    An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
    You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

    Example 1:
        Input: nums = [1]
        Output: true
    Explanation:
        There is only one element. So the answer is true.

    Example 2:
        Input: nums = [2,1,4]
        Output: true
    Explanation:
        There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.

    Example 3:
        Input: nums = [4,3,1,6]
        Output: false
    Explanation:
        nums[1] and nums[2] are both odd. So the answer is false.

    Constraints:
        1 <= nums.length <= 100
        1 <= nums[i] <= 100
 */


public class specialArray1_3151 {
    // Method to return boolean solution
    public boolean isArraySpecial(int[] nums) {
        /*
            This problem will involve a very simple approach with the passed in parameter and a for loop.
            The question essentially asks if there are any adjacent numbers that are either both odd or both
            even (parity) within the array. What we can do is use a for loop to loop through the nums array and at each step,
            check if the current number and the number after it have the same parity. We can do this by using a modulo operator
            against the two current numbers. If they have the same parity at any given point, the array is not special and we can return false.
            Otherwise we can return true because we know the array is special. The time complexity for this solution is O(n),
            and space complexity is O(1). The best we can do is O(n) here because we must scan the entire
            array to ensure that the whole sequence is either special or not.
         */
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] % 2 == nums[i+1] % 2) {
                return false;
            }
        }
        return true;
    }


    // Main method to run program
    public static void main(String[] args) {

    }
}
