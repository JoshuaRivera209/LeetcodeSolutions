/*

    Given an array of strings strs, group the anagrams together. You can return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



    Example 1:

    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    Example 2:

    Input: strs = [""]
    Output: [[""]]
    Example 3:

    Input: strs = ["a"]
    Output: [["a"]]


    Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.

 */


import java.util.*;

public class groupAnagrams_49 {
    // Function to group anagrams and provide result
    public static List<List<String>> groupAnagrams(String[] strs) {
        // Check if there is only 1 string in the parameter
        // If there is, then we just return a list of lists containing the 1 string
        if(strs.length == 1) {
            List<List<String>> res = new ArrayList();
            res.add(new ArrayList<>());
            res.get(0).add(strs[0]);
            return res;
        // If the list parameter is empty, then we just return an empty list of lists
        } else if (strs.length == 0) {
            List<List<String>> res = new ArrayList();
            res.add(new ArrayList<>());
            return res;
        }
        // Otherwise we proceed normally and group the anagrams
        // Initialize a hashmap that will be used to group the anagrams properly
        HashMap<String, ArrayList<String>> result = new HashMap<>();
        // Loop through every string in the list of strings
        for (String str: strs) {
            // Take the current string and turn it into a character array
            char[] charArr = str.toCharArray();
            // Sort the array and create a string variable for the sorted result
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            // Check if this sorted string exists as a key in the hashmap
            // If it doesn't, we add it and as well the current string to the hashmap
            // under the newly create key
            if(!result.containsKey(sortedStr)) {
                result.put(sortedStr, new ArrayList<>());
                result.get(sortedStr).add(str);
            // Otherwise we know the key exists and we can add it to the appropriate list of common anagrams
            } else {
                result.get(sortedStr).add(str);
            }
        }
        // Create a list of lists to return and add all the values (lists) from the hashmap to it and return it
        List<List<String>> res = new ArrayList(result.values());
        return res;
    }
    // Main function to call groupAnagrams and get result
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = {""};
        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs2));
    }
}
