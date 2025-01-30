/*
    You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
    Return the length of the longest substring containing the same letter you can get after performing the above operations.

    Example 1:
        Input: s = "ABAB", k = 2
        Output: 4
        Explanation: Replace the two 'A's with two 'B's or vice versa.

    Example 2:
        Input: s = "AABABBA", k = 1
        Output: 4
        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        The substring "BBBB" has the longest repeating letters, which is 4.
        There may exists other ways to achieve this answer too.

    Constraints:
        1 <= s.length <= 105
        s consists of only uppercase English letters.
        0 <= k <= s.length
 */

import java.util.Collections;
import java.util.HashMap;

public class longestRepeatingCharReplacement_424 {
    // Method to find and return solution
    public static int characterReplacement(String s, int k) {
        /*
            The approach for this problem will involve the use of a HashMap and sliding window technique. We will keep track of the character count with
            the hashmap, and use left and right pointers to move through the string. The idea is to grow the size of the window with the right pointer while
            keeping track of the amount of characters that can be replaced. We will do this by subtracting the highest count in the hashmap from the length of the
            window. As long as this result is <= k, then we have a valid window because the count tells us how many letters will need to be replaced. The result will
            be the largest valid window size that is determined as the pointers move through the string. Once the result is greater than k, we will move the left pointer
            until the window becomes valid again. The time complexity for this approach comes out to O(n), and the space complexity is O(m), where m is the size of the
            hashmap.
         */
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        int maxF = 0;
        for (int r=0; r<s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(r)));
            while ((r-l+1) - maxF > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }

    // Main method to run program
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }
}
