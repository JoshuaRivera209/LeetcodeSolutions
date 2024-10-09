/*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

    Example 1:
        Input: height = [1,8,6,2,5,4,8,3,7]
        Output: 49
        Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

    Example 2:
        Input: height = [1,1]
        Output: 1

    Constraints:
        n == height.length
        2 <= n <= 105
        0 <= height[i] <= 104
 */

public class containerWithMostWater_11 {
    // Method to find and return the maximum amount of water the container can store
    public static int maxArea(int[] height) {
        /*
            This problem will use a two pointer approach. One pointer on the leftmost side of the array,
            and one pointer on the rightmost side of the array. We will have a maxArea variable,
            and a currentArea variable that will calculate the area of the water as we loop
            through the array and update the maxArea variable when appropriate. Since there can be
            cases where the container can have a small length but a large height, we need to scan the whole
            array to ensure we cover all possible outcomes. We will move the pointers inward towards the center
            when the height of the left pointer is smaller than the right pointer, or vice versa.
            Since we have to scan the whole array through one pass, the time complexity of this
            implementation is O(n), and the space complexity is O(1).
         */
        // Declare our variables for the problem
        int maxArea = 0;
        int l = 0;
        int r = height.length-1;
        // Loop through array and find the max area
        while(l<r) {
            maxArea = Math.max(maxArea, ((r-l) * Math.min(height[l], height[r])));
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        // Return result
        return maxArea;
    }

    // Main method to run program
    public static void main(String[] args) {
        int[] test = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(test));
    }
}
