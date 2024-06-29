/*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.



    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

    Example 3:

    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.



    Constraints:

        1 <= s.length <= 2 * 105
        s consists only of printable ASCII characters.
 */

public class validPalindrome_125 {
    // Function that checks if the character is valid or not
    public static boolean isValid(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
    // Function to convert to lowercase
    public static char toLowerCase(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return c;
        }
        return (char)(c + 32);
    }
    // Function that will be called to check if the provided string is a
    // valid palindrome or not.
    public static boolean isPalindrome(String s) {
        // Before we process the string for comparison we'll handle some minor potential edge cases
        // If the length of the string is 0 or 1 then we know it will always be true
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        // Get rid of any leading or trailing whitespace from the string before comparisons
        s = s.trim();
        // Use a while loop and two pointer method to compare the characters
        // on both ends of the string while ignoring alphanumeric characters
        int i = 0;
        int j = s.length()-1;
        // Use a while loop to loop through the array
        while (i < j) {
            // Increment i while it is not equal to a valid character
            while (i<j && !isValid(s.charAt(i))) {
                i++;
            }
            // Increment j while it is not equal to a valid character
            while (j>i && !isValid(s.charAt(j))) {
                j--;
            }
            // Return false if the characters are not equal, thus invalidating the string as a palindrome
            if (toLowerCase(s.charAt(i)) != toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        // If we exit the while loop then we know the string is a valid palindrome
        // and can return the result.
        return true;
    }

    // Main driver function
    public static void main(String[] args) {
        String test = "racecar";
        String test2 = " race a car";
        String test3 = "A man, a plan, a canal: Panama";
        String test4 = ".,";
        String test5 = "...,";
        System.out.println(isPalindrome(test3));
    }
}
