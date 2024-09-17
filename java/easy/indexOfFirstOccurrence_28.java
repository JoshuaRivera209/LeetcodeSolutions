/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:
    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.
 */



public class indexOfFirstOccurrence_28 {
    public static int search(String needle, String haystack) {
        // Java has a built-in function for checking strings, so we will use that
        // Check if the haystack has the needle, and if it does then return the index
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        // Return -1 if no result is found
        return -1;
    }

    // Main method to run program
    public static void main(String[] args) {
        String needle = "leeto";
        String haystack = "leetcode";
        System.out.println(search(needle, haystack));
    }
}
