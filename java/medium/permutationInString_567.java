/*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
    In other words, return true if one of s1's permutations is the substring of s2.

    Example 1:
        Input: s1 = "ab", s2 = "eidbaooo"
        Output: true
        Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:
        Input: s1 = "ab", s2 = "eidboaoo"
        Output: false

    Constraints:
        1 <= s1.length, s2.length <= 104
        s1 and s2 consist of lowercase English letters.
 */

import java.util.HashSet;

public class permutationInString_567 {
    // method to return boolean based on comparison of s1 and s2
    public static boolean checkInclusion(String s1, String s2) {
        /*
            MY INITIAL APPROACH:
                The approach for this problem will include the use of some sort of hashing - presumably HashSet with a sliding window technique.
                We can use a HashSet to store the characters of s1. Using a sliding window, we can grow the size of the window as long as the HashSet
                contains the character at the right pointer. If the window ever reaches the same size as the HashSet, then we know we have reached a
                permutation of s1. We return true. If we reach a character that is not in the HashSet before the size matches, then we move the left
                pointer up to the right, and rinse & repeat until we reach the end of the string or find a permutation. With this approach, the
                time complexity = O(n) where n is the string s2, and the space complexity = O(m), where m is the string s1 because of the need to store
                it in a HashSet.
         */
        /*
            CORRECT APPROACH:
                We will be using a *fixed* sliding window technique. Since the input only contains lowercase english characters, we know that there are
                only 26 possible character inputs. We could use 2 HashMaps to store the character and counts of each string, however an alternative approach
                is to work with arrays. Since arrays are initialized with a default value of 0, it is possible to initialize 2 arrays of size 26, and then increment
                the count of the characters in the string using their ASCII values to access their position. Doing this to s1 will allow us to use the length of s1
                as a starting point for the right pointer to loop through s2. We will have a variable that contains the count of matches between the two strings, and
                if this variable ever reaches 26 then we automatically know there is a permutation and return immediately. The left pointer for this problem will start
                at 0 and increment after each iteration to ensure the sliding window maintains a fixed size. On a basic level, the idea is to create a window the size of s1
                and shift this window through s2, counting the characters in each window. If the characters of s1 and their count ever appear in the window then we return true.
                This approach requires a fair bit of intuition, but results in a nice O(n) time complexity with a O(1) space complexity.
         */
        // clear edge case where s1 is larger than s2
        if (s1.length() > s2.length()) return false;
        // initialize arrays
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        // increment counts of s1 & s2 arrays
        for (int i=0; i<s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        // setup matches variable
        int matches = 0;
        for (int i=0; i<26; i++) {
            if (s1Count[i] == s2Count[i]) matches++;
        }

        // use sliding window on s2
        int l = 0;
        // we start the right pointer at the length of s1 because this is the fixed size we want; we will move the left pointer to maintain this
        for (int r = s1.length(); r<s2.length(); r++) {
            // if matches == 26 at any point we return
            if (matches == 26) return true;

            int index = s2.charAt(r) - 'a';
            s2Count[index]++;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            s2Count[index]--;
            if (s1Count[index] == s2Count[index]) {
                matches++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            l++;
        }
        return matches==26;
    }

    // main method to run program
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        String s3 = "eidbaooo";
        System.out.println(checkInclusion(s1, s1));
    }
}
