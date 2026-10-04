/*
 * Program Name: Subarray Sum Equals K
 * Description: This program counts the number of contiguous
 *              subarrays whose sum is equal to k.
 */

import java.util.HashMap;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        // Empty prefix sum
        prefixSumMap.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum = currentSum + nums[i];

            int requiredSum = currentSum - k;

            if (prefixSumMap.containsKey(requiredSum)) {
                count = count + prefixSumMap.get(requiredSum);
            }

            prefixSumMap.put(
                    currentSum,
                    prefixSumMap.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println("Number of Subarrays: " + result);
    }
}