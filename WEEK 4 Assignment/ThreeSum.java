/*
 * Program Name: 3Sum
 * Description: This program finds all unique triplets
 *              whose sum is equal to zero.
 */

import java.util.Arrays;

public class ThreeSum {

    public static void threeSum(int[] nums) {

        Arrays.sort(nums);

        System.out.println("Triplets:");

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    System.out.println(
                            "[" + nums[i] + ", "
                            + nums[left] + ", "
                            + nums[right] + "]"
                    );

                    left++;
                    right--;

                    // Skip duplicate values
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        threeSum(nums);
    }
}