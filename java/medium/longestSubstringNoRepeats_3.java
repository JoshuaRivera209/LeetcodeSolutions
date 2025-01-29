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
    /*
        We will use 2 pointers to move through this problem, a left and a right pointer.
        We will use a hashset that will contain the characters of the sequence. Using a hashset
        will ensure that the sequence is unique. Using a for loop, we will go through the array and add
        each character to the hashset, and then clear it when we reach a repeating character. With this approach,
        the idea is that the hashset will only contain the current unique sequence, and when we reach the end of the sequence
        we will clear the hashmap and restart. We increment the left pointer within the while loop to catch it back up to the right
        pointer, since we know the size of the sequence will be the amount of times we need to increment the left pointer. When
        calculating the bestSize, we use (r-l)+1. We add 1 here because of the offset when indexing from 0.

        This approach only runs through the string one time, and will have a runtime of O(n) with a space complexity of O(n)
        because of our use of a hashset.
     */

    // Method to loop through string and find the longest substring
    // with no repeating characters.
    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int bestSize = 0;
        HashSet<Character> chars = new HashSet<>();
        for (int r=0; r<s.length(); r++) {
            while(chars.contains(s.charAt(r))) {
                chars.remove(s.charAt(l));
                l++;
            }
            chars.add(s.charAt(r));
            bestSize = Math.max(bestSize, (r-l) + 1);
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
        System.out.println(lengthOfLongestSubstring(test3));
    }
}
