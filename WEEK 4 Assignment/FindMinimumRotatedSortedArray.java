/*
 * Program Name: Find Minimum in Rotated Sorted Array
 * Description: This program finds the minimum element
 *              using modified binary search.
 */

public class FindMinimumRotatedSortedArray {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[right]) {

                // Minimum is on the right side
                left = middle + 1;

            } else {

                // Minimum is at middle or on the left side
                right = middle;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 1, 2};

        int result = findMin(nums);

        System.out.println("Minimum Element: " + result);
    }
}