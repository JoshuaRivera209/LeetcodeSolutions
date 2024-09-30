/*
    Given a string s consisting of lowercase English letters, return the first letter to appear twice.

    Note:
        A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
        s will contain at least one letter that appears twice.

    Example 1:
    Input: s = "abccbaacz"
    Output: "c"
    Explanation:
    The letter 'a' appears on the indexes 0, 5 and 6.
    The letter 'b' appears on the indexes 1 and 4.
    The letter 'c' appears on the indexes 2, 3 and 7.
    The letter 'z' appears on the index 8.
    The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.

    Example 2:
    Input: s = "abcdd"
    Output: "d"
    Explanation:
    The only letter that appears twice is 'd' so we return 'd'.

    Constraints:
        2 <= s.length <= 100
        s consists of lowercase English letters.
        s has at least one repeated letter.
 */

import java.util.ArrayList;

public class firstLetterToAppearTwice_2351 {
    // Method to find and return the first letter that appears twice
    public static char repeatedCharacter(String s) {
        // Use a character arraylist and add new characters until we encounter a duplicate
        ArrayList<Character> charsArray = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // Checks if the array has the current character and adds it if not
            if (!charsArray.contains(s.charAt(i))) {
                charsArray.add(s.charAt(i));
              /*
                  If it does already exist then we have our answer and can return the character.
                  Based on the constraints of the problem this else statement will always get caught, but because
                  of the scope at which the return statement is, we also need to include a return statement outside the loop
                  to make Java happy.
               */

            } else {
                return s.charAt(i);
            }
        }
        return 0;
    }

    // Main method to run program
    public static void main(String[] args) {
        String test = "aabb";
        System.out.println(repeatedCharacter(test));
    }
}
