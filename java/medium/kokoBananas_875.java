/*
    Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
    Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
    If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    Return the minimum integer k such that she can eat all the bananas within h hours.

    Example 1:
        Input: piles = [3,6,7,11], h = 8
        Output: 4

    Example 2:
        Input: piles = [30,11,23,4,20], h = 5
        Output: 30

    Example 3:
        Input: piles = [30,11,23,4,20], h = 6
        Output: 23

    Constraints:
        1 <= piles.length <= 104
        piles.length <= h <= 109
        1 <= piles[i] <= 109
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class kokoBananas_875 {
    // Method to return k
    public static int minEatingSpeed(int[] piles, int h) {
        /*
            This problem will use a binary search approach to avoid the use of a brute-force
            solution to the problem. Because of the constraints of the problem, we know that the maximum
            number of bananas that might be eaten is the maximum found in the input array. For example if
            variable h is equal to the size of the array, then Koko would need to consume each pile every hour
            before the guards come back. This would mean k must be equal to the maximum number in the piles as the example shows.
            The problem asks for the least amount of bananas Koko can eat because she is a slow eater, so in order to get the optimal
            amount of bananas, we will use a binary search. The range of the search will be from 1 to the highest amount found in the
            array because of the explained constraint. We can calculate the amount of time it will take Koko to consume a pile by dividing
            the size of the pile (piles[i]) by the rate the pile is being consumed k. This would give us piles[i] / k. If this value is less than
            h, then we know that the piles will be consumed within the time, and we can search the left side of the array as per the principles of a
            binary search. The binary search will find the smallest number that would allow us to consume all the piles under the time constraint,
            and we can keep track of the current best value with a global variable. This solution comes out to a time complexity of O(nlogm), and a
            space complexity of O(1).
         */
        int l = 0, r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r) {
            int k = (l + r) / 2;
            int hours = 0;
            for (int num : piles) {
                hours += Math.ceil((double)num / k);
            }
            if (hours <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
    // Main method to run program
    public static void main(String[] args) {
        int[] pile = new int[] {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(pile, h));
    }
}
