/*
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



    Example 1:

    Input: nums = [1,1,1,2,2,3], k = 2
    Output: [1,2]

    Example 2:

    Input: nums = [1], k = 1
    Output: [1]



    Constraints:

        1 <= nums.length <= 105
        -104 <= nums[i] <= 104
        k is in the range [1, the number of unique elements in the array].
        It is guaranteed that the answer is unique.



    Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */


import java.util.*;

public class topKFrequentElements_347 {

    // Top K Frequent function that will give an output of the
    // K most frequent elements
    public static int[] topKFrequent(int[] nums, int k) {
        // Use a hashmap and a for loop to organize the frequency
        // in appearance of elements
        HashMap<Integer, Integer> num_freq = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            // If key already exists then increment frequency
            if (num_freq.containsKey(nums[i])) {
                num_freq.put(nums[i], num_freq.get(nums[i]) + 1);
              // Otherwise initialize it
            } else {
                num_freq.put(nums[i], 1);
            }
        }
        // Iterate through keyset of hashmap and organize pairs into
        // frequency list, where index = frequency and value = list of numbers
        // with said frequency
        List<List<Integer>> sorted_freqs = new ArrayList<>();
        // Initialize list of lists first
        for (int i=0; i<nums.length + 1;i++) {
            sorted_freqs.add(new ArrayList<>());
        }
        // Sort pairs appropriately
        for (Map.Entry<Integer, Integer> entry : num_freq.entrySet()) {
            sorted_freqs.get(entry.getValue()).add(entry.getKey());
        }
        // Iterate backwards from the last value of the list
        // and add the first k values to the result list
        List<Integer> result = new ArrayList<>(k);
        for (int i=sorted_freqs.size()-1; i>-1;i--) {
            for (int j=0; j<sorted_freqs.get(i).size();j++) {
                result.add(sorted_freqs.get(i).get(j));
            }
            if (result.size() == k){
                break;
            }
        }
        // Convert result list to proper data type
        // (I'm unsure of another way to do this at the moment)
        int[] output = new int[k];
        for (int i=0;i<output.length;i++) {
            output[i] = result.get(i);
        }
        return output;
    }

    // Main driver function
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        topKFrequent(nums, k);
    }
}
