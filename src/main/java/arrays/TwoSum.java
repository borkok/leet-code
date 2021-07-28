package arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    private static List<Integer> mergeLists(List<Integer> listA, List<Integer> listB) {
        listA.addAll(listB);
        return listA;
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] { 0, 1 };
        }
        //int[] result = quadratic(nums, target);
        int[] result = linear(nums, target);
        return result;
    }

    // max 104 + 218 = 322 operations
    // but more memory
    private int[] linear(int[] nums, int target) {
        // make hash map and find min and max
        Map<Integer, List<Integer>> indexByNum = new HashMap<>();
        int min = 110;
        int max = -110;
        for (int i = 0; i < nums.length; i++) {
            indexByNum.merge(nums[i],
                             new LinkedList<>(Collections.singletonList(i)),
                             TwoSum::mergeLists);
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        // try all possible sums
        for (int left = min; left < max; left++) {
            int right = target - left;
            if (left == right) {
                if (indexByNum.containsKey(left) && indexByNum.get(left).size() > 1) {
                    return new int[] { indexByNum.get(left).get(0), indexByNum.get(left).get(1) };
                }
            }
            if (indexByNum.containsKey(left) && indexByNum.containsKey(right)) {
                return new int[] { indexByNum.get(left).get(0), indexByNum.get(right).get(0) };
            }
        }
        throw new IllegalArgumentException();
    }


    //n2/2 => max 104^2 / 2 = 5 000 operations
    private int[] quadratic(int[] nums, int target) {
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
