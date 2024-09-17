/*
    Given an integer x, return true if x is a
    palindrome,and false otherwise.

    Example 1:
    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.

    Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Example 3:
    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

    Constraints:
    -231 <= x <= 231 - 1
 */

public class palindromeNumber_9 {
    // Method to return solution using a StringBuilder
    public static boolean isPalindrome(int x) {
        // Check if integer is negative, if it is then we know it does not
        // read the same forward and back and can exit
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        if (x < 0) {
            return false;
        }
        // If the length of the integer is 0 or 1 we know it will be true
        if (sb.length() == 0 || sb.length() == 1) {
            return true;
        }
        // Since the integer is a string, we can use the same approach as comparing letters
        // except with less constraints because we know we will be only be dealing with numbers
        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        // If we exit the loop then we know the palindrome is valid
        return true;
    }

    // --------------- Come back to non-string method -------------- \\


    // Method to return result without converting the number to a string
    public static boolean isIntPalindrome(int x) {
        // If the number is negative or ends in 0 then we know it is not a palindrome
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        // If the number is a single digit then we know it is a palindrome
        if (x < 10) {
            return true;
        }
        //
        return true;
    }

    // Main method to run program
    public static void main(String[] args) {
        int test = -121;
        System.out.println(isPalindrome(test));
    }
}
