/*
    Given a string s consisting of words and spaces, return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only.

    Example 1:
    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.

    Example 2:
    Input: s = "   fly me   to   the moon  "
    Output: 4
    Explanation: The last word is "moon" with length 4.

    Example 3:
    Input: s = "luffy is still joyboy"
    Output: 6
    Explanation: The last word is "joyboy" with length 6.



    Constraints:
        1 <= s.length <= 104
        s consists of only English letters and spaces ' '.
        There will be at least one word in s.
 */


public class lengthOfLastWord_58 {
    // Method to find and return the length of the last word in the string
    public static int lengthOfLastWord(String s) {
        // Simple string manipulation problem
        // We will do some preprocessing by trimming the string.
        s = s.trim();
        // Return the length of the last word in the array
        return s.length() - (s.lastIndexOf(' ')) - 1;
    }
    // Main method to run program
    public static void main(String[] args) {
        String test = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(test));
    }
}
