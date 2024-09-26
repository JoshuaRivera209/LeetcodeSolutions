/*
    Given a string s, find the length of the longest
    substring
    without repeating characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

    Constraints:
        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.
 */


import java.util.HashSet;

public class longestSubstringNoRepeats_3 {
    /*  We will try a sliding window approach to this problem by looping
        through the string and expanding the window each time we encounter a character
        that is not repeating. Once we find a repeat we will set the current length to keep
        track of the max substring length. We will do this until one of the pointers reaches the
        end of the string.
     */

    // Method to loop through string and find the longest substring
    // with no repeating characters.
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int bestSize = 0;
        HashSet<Character> chars = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (chars.contains(s.charAt(right))) {
                chars.remove(s.charAt(left));
                left++;
            }
            chars.add(s.charAt(right));
            bestSize = Math.max(bestSize, (right - left) + 1);
        }
        return bestSize;
    }


    // Main method to run program
    public static void main(String[] args) {
        String test = "pwwkew";
        String test2 = "bbbbb";
        String test3 = "abcabcbb";
        String test4 = " ";
        String test5 = "5678917256";
        System.out.println(lengthOfLongestSubstring(test5));
    }
}
