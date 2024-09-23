/*
    A sentence is a string of single-space separated words where each word consists only of lowercase letters.

    A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

    Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

    Example 1:
    Input: s1 = "this apple is sweet", s2 = "this apple is sour"
    Output: ["sweet","sour"]

    Explanation:
    The word "sweet" appears only in s1, while the word "sour" appears only in s2.

    Example 2:
    Input: s1 = "apple apple", s2 = "banana"
    Output: ["banana"]

    Constraints:
        1 <= s1.length, s2.length <= 200
        s1 and s2 consist of lowercase English letters and spaces.
        s1 and s2 do not have leading or trailing spaces.
        All the words in s1 and s2 are separated by a single space.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class uncommonFromSentences_884 {
    // Method to get solution
    public static String[] uncommonFromSentences(String s1, String s2) {
        // Because we do not know how many uncommon words there are, we will
        // use an ArrayList because of its ability to dynamically resize
        ArrayList<String> result = new ArrayList<>();
        // Initialize hashmap and build it with function call
        HashMap<String, Integer> stringMap = buildMap(s1, s2);
        // Once we have the hashmap containing the word counts we can add
        // all the words that have exactly 1 appearance to our result array
        for (Map.Entry<String, Integer> entry : stringMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        // Return solution
        return result.toArray(new String[0]);
    }

    // Method to build hashmap of words
    public static HashMap<String, Integer> buildMap(String s1, String s2) {
        // Initialize map that will keep count of all words
        HashMap<String, Integer> stringMap = new HashMap<>();
        // Split the strings into arrays
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        // Parse through each string and add the words to our hashmap
        // while keeping track of the amount of appearances
        for (int i=0; i<s1Arr.length; i++) {
            if (!stringMap.containsKey(s1Arr[i])) {
                stringMap.put(s1Arr[i], 1);
            } else {
                stringMap.put(s1Arr[i], stringMap.get(s1Arr[i]) + 1);
            }
        }
        for (int i=0; i<s2Arr.length; i++) {
            if (!stringMap.containsKey(s2Arr[i])) {
                stringMap.put(s2Arr[i], 1);
            } else {
                stringMap.put(s2Arr[i], stringMap.get(s2Arr[i]) + 1);
            }
        }
        // Return the built hashmap
        return stringMap;
    }

    // Main method to run program
    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
    }
}
