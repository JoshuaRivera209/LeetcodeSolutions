/*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    Example 1:
        Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.

    Constraints:
        1 <= prices.length <= 105
        0 <= prices[i] <= 104
 */

public class bestTimeToBuySellStock_121 {
    // Method to find and return the maximum profit
    public static int maxProfit(int[] prices) {
        /*
            This problem will use a 2-pointer sliding window approach. We will have a
            low/buy pointer and a high/sell pointer. The idea is that we should set the low pointer every time
            we reach a smaller value, and increment the high pointer each time we hit a larger value, as long as
            the low pointer < high pointer and the high pointer is also within bounds. The maximum profit will be
            updated each time we encounter a profit that is higher than the current max profit. We do this in
            one pass through the array, for a runtime complexity of O(n) and a space complexity of O(1).
         */
        int maxProf = 0;
        int l = 0;
        int h = 1;
        while (l < h && h < prices.length) {
            if(prices[l] < prices[h]) {
                // Compare and take the higher value between the current max profit and the difference between
                // the values where the high and low pointer are currently at.
                maxProf = Math.max(maxProf, prices[h] - prices[l]);
                // Incrementing the high pointer here will expand the window.
                h++;
            } else {
                /*
                    If we reach a value that is lower than the current low pointer then we will set the low pointer
                    to where the high pointer is. The reason this works is that the high pointer will always be ahead
                    of the low pointer. We then increment the high pointer once more to keep it ahead of the low pointer.
                 */
                l = h;
                h++;
            }
        }
        return maxProf;
    }

    // Main method to run program
    public static void main(String[] args) {
        int[] test = new int[] {1,2,4,2,5,7,2,4,9,0,9};
        System.out.println(maxProfit(test));
    }
}
