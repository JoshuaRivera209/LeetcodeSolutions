/*

    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



    Example 1:

    Input: s = "anagram", t = "nagaram"
    Output: true
    Example 2:

    Input: s = "rat", t = "car"
    Output: false


    Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.


    Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */


import java.util.Arrays;

public class validAnagram_242 {
    // Function to check for anagram
    public static boolean isAnagram(String s, String t) {
        // First thing we can do is simply check if the strings are the same size
        // If they aren't then it definitely is not valid
        if(s.length() != t.length() || s == null || t == null) {
            return false;
        }
        // We know that they are the same length, so we can continue with the comparison
        // Approach for this will be to sort both strings and return assert equals comparison of them
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        Arrays.sort(s_arr);
        Arrays.sort(t_arr);
        String sorted_s = new String(s_arr);
        String sorted_t = new String(t_arr);
        return sorted_t.equals(sorted_s);
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
