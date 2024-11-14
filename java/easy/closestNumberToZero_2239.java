/*
    Given an integer array nums of size n, return the number with the value closest to 0 in nums. If there are multiple answers, return the number with the largest value.

    Example 1:
        Input: nums = [-4,-2,1,4,8]
        Output: 1
        Explanation:
        The distance from -4 to 0 is |-4| = 4.
        The distance from -2 to 0 is |-2| = 2.
        The distance from 1 to 0 is |1| = 1.
        The distance from 4 to 0 is |4| = 4.
        The distance from 8 to 0 is |8| = 8.
        Thus, the closest number to 0 in the array is 1.

    Example 2:
        Input: nums = [2,-1,1]
        Output: 1
        Explanation: 1 and -1 are both the closest numbers to 0, so 1 being larger is returned.

    Constraints:
        1 <= n <= 1000
        -105 <= nums[i] <= 105
 */

public class closestNumberToZero_2239 {
    // Method to find and return closest number to 0
    public static int findClosestNumber(int[] nums) {
        /*
            The initial approach I will take for this problem will try to store the current
            closest number in a variable, and in the event we encounter numbers with the same distance,
            we will reassign the variable accordingly based on which value is larger. The only case where this
            should happen is when the negative and positive of a particular number are in the array. For example,
            if there is a -5 in the array and a 5 in the array, we would compare them and take 5 since it is the larger
            number but has the same distance from 0. Since we need to consider all numbers, the best time complexity
            we can get from this approach is O(n). I believe this approach accomplishes a space complexity of O(1).

            Another idea to approach this problem would be to sort the array first, and then take the first value of the array.
            This approach quickly fails once we consider the fact that negative values are also present in the array.
         */
        // We will try to maintain these two variables simultaneously since they correspond to one another.
        // Best val is the actual value, lowDistance is the distance from the bestVal to 0.
        int bestVal = 0;
        int lowDistance = Integer.MAX_VALUE;
        // Loop through array of numbers to find closest distance to zero.
        for (int i=0; i<nums.length; i++) {
            // If we encounter a 0 at all in the array, there is no other possible answer besides 0.
            // We can return this and exit.
            // Even though we do initialize bestVal to 0 we cannot return it because it is possible
            // this value will change before we reach a 0 in the array.
            if (nums[i] == 0) return 0;
            // In order to properly maintain the 2 variables, we will only update them
            // under the proper conditions.
            // Take the absolute value of the number to check its distance to 0
            int curNum = Math.abs(nums[i]);
            if (curNum <= lowDistance) {
                if (curNum == Math.abs(bestVal)) {
                    bestVal = Math.max(nums[i], bestVal);
                } else {
                    bestVal = nums[i];
                    lowDistance = curNum;
                }
            }
        }
        return bestVal;
    }

    // Main method to run program
    public static void main(String[] args) {
        int[] nums = new int[] {2,1,1,-1,100000};
        System.out.println(findClosestNumber(nums));
    }
}
