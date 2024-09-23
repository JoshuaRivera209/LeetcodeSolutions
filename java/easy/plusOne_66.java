/*
    You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
    Increment the large integer by one and return the resulting array of digits.

    Example 1:
    Input: digits = [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Incrementing by one gives 123 + 1 = 124.
    Thus, the result should be [1,2,4].

    Example 2:
    Input: digits = [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
    Incrementing by one gives 4321 + 1 = 4322.
    Thus, the result should be [4,3,2,2].

    Example 3:
    Input: digits = [9]
    Output: [1,0]
    Explanation: The array represents the integer 9.
    Incrementing by one gives 9 + 1 = 10.
    Thus, the result should be [1,0].

    Constraints:
        1 <= digits.length <= 100
        0 <= digits[i] <= 9
        digits does not contain any leading 0's.
 */


import java.util.Arrays;

public class plusOne_66 {
    // Method to increment integer and return in as int[]
    public static int[] plusOne(int[] digits) {
        // Loop through array in reverse order
        for (int i = digits.length-1; i>=0; i--) {
            // If current digit ends in anything but 9 we can increment and exit
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If it is 9 then we set the value equal to 0 and continue through the loop
            digits[i] = 0;
        }
        // If we exit the loop then we know that all values are 9 and we need to add another digit place.
        // We resize the array and since all digits are 9, we just set the first place to 1 and the rest
        // will be 0 by default since that is the default value when creating new arrays.
        // Example: If I am at 99, the value 000 will be the new array when it is resized. We then add a 1
        // at the beginning to make it 100.
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
    // Main method to run program
    public static void main(String[] args) {
        int[] digits = new int[] {9, 8};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
