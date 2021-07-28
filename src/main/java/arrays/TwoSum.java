package arrays;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target,
 * in any order.
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 * Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] { 0, 1 };
        }
        int left = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((left + nums[i]) == target) {
                return new int[] { 0, i };
            }
        }
        return new int[] { 0, nums.length-1 };
    }
}
