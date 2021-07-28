package arrays;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target,
 * in any order.
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 * <p>
 * Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] { 0, 1 };
        }
        for (int left = 0; left < nums.length; left++) {
            for (int right = left + 1; right < nums.length; right++) {
                if ((nums[left] + nums[right]) == target) {
                    return new int[] { left, right };
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
