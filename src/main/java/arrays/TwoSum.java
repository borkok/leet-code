package arrays;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target,
 * in any order.
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 * <p>
 * Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] { 0, 1 };
        }
        //int[] result = quadratic(nums, target);
        int[] result = linear(nums, target);
        return result;
    }

    //  10^4 + 10^4 = 2 * 10^4 operations
    private int[] linear(int[] nums, int target) {
        // make hash map
        NumberIndices numberIndices = new NumberIndices(nums);

        for (int leftIndex = 0; leftIndex < nums.length; leftIndex++) {
            int left = nums[leftIndex];
            int right = target - left;
            Optional<Integer> rightIndex = left == right ?
                                           numberIndices.findSecondIndexOf(left) :
                                           numberIndices.findIndexOf(right);
            if (rightIndex.isPresent()) {
                return new int[] { leftIndex, rightIndex.get() };
            }
        }
        throw new IllegalArgumentException();
    }

    private static class NumberIndices {
        private final Map<Integer, List<Integer>> indexByNum;

        NumberIndices(int[] nums) {
            indexByNum = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                indexByNum.merge(nums[i],
                                 new LinkedList<>(Collections.singletonList(i)),
                                 this::mergeLists);

            }
        }

        private List<Integer> mergeLists(List<Integer> listA, List<Integer> listB) {
            listA.addAll(listB);
            return listA;
        }

        Optional<Integer> findIndexOf(Integer number) {
            if (indexByNum.containsKey(number)) {
                return Optional.of(indexByNum.get(number).get(0));
            }
            return Optional.empty();
        }

        Optional<Integer> findSecondIndexOf(Integer number) {
            if (indexByNum.containsKey(number) && indexByNum.get(number).size() > 1) {
                return Optional.of(indexByNum.get(number).get(1));
            }
            return Optional.empty();
        }
    }

    //n2/2 => maxNumber 10^4^2 / 2 = 10^8 / 2 = 5 * 10^7 operations
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
