/*
 * Program Name: Product of Array Except Self
 * Description: This program finds the product of all elements
 *              except the element at the current position.
 *              Division is not used.
 */

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        // Store product of elements to the left
        int leftProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        // Multiply by product of elements to the right
        int rightProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = productExceptSelf(nums);

        System.out.print("Output: ");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
