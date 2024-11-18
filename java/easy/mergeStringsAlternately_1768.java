/*
    You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
    Return the merged string.

    Example 1:
        Input: word1 = "abc", word2 = "pqr"
        Output: "apbqcr"
        Explanation: The merged string will be merged as so:
        word1:  a   b   c
        word2:    p   q   r
        merged: a p b q c r

    Example 2:
        Input: word1 = "ab", word2 = "pqrs"
        Output: "apbqrs"
        Explanation: Notice that as word2 is longer, "rs" is appended to the end.
        word1:  a   b
        word2:    p   q   r   s
        merged: a p b q   r   s

    Example 3:
        Input: word1 = "abcd", word2 = "pq"
        Output: "apbqcd"
        Explanation: Notice that as word1 is longer, "cd" is appended to the end.
        word1:  a   b   c   d
        word2:    p   q
        merged: a p b q c   d

    Constraints:
        1 <= word1.length, word2.length <= 100
        word1 and word2 consist of lowercase English letters.
 */

public class mergeStringsAlternately_1768 {
    // Method to merge strings alternately and return result string
    public static String mergeAlternately(String word1, String word2) {
        /*
            The approach for this problem is quite simple. Loop through the strings, adding characters
            to a string builder alternately. Once we reach the end of a string, we stop adding characters from
            the shorter string to avoid a bounds error. The upper bound for the loop will be the length of the
            longer string. The time and space complexity of this approach is O(n) for both.
         */
        // Get length of longer string
        int length = Math.max(word1.length(), word2.length());
        StringBuilder res = new StringBuilder();
        for (int i=0; i<length; i++) {
            // We use -1 in the conditions to avoid going out of bounds
            if (i > word1.length()-1) {
                res.append(word2.charAt(i));
            } else if (i > word2.length()-1) {
                res.append(word1.charAt(i));
            } else {
                res.append(word1.charAt(i));
                res.append(word2.charAt(i));
            }

        }
        return res.toString();
    }
    // Main method to run program
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqrs";
        System.out.println(mergeAlternately(word1, word2));
    }
}
