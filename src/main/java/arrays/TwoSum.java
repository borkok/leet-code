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

    // maxNumber 104 + 218 = 322 operations
    // but more memory
    private int[] linear(int[] nums, int target) {
        // make hash map and find minNumber and maxNumber
        NumberIndices numberIndices = new NumberIndices(nums);
        int min = numberIndices.minNumber();
        int max = numberIndices.maxNumber();

        // try all possible pair of integers that sum to target
        for (int left = min; left < max; left++) {
            int right = target - left;
            Optional<Pair> indices = numberIndices.findIndicesOf(new Pair(left, right));
            if (indices.isPresent()) {
                return new int[] { indices.get().left, indices.get().right };
            };
        }
        throw new IllegalArgumentException();
    }

    private static class NumberIndices {
        private final Map<Integer, List<Integer>> indexByNum;
        private int min;
        private int max;

        NumberIndices(int[] nums) {
            indexByNum = new HashMap<>();
            min = 110;
            max = -110;
            for (int i = 0; i < nums.length; i++) {
                indexByNum.merge(nums[i],
                                 new LinkedList<>(Collections.singletonList(i)),
                                 TwoSum::mergeLists);
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
            }
        }

        int minNumber() {
            return min;
        }

        int maxNumber() {
            return max;
        }

        Optional<Pair> findIndicesOf(Pair numbers) {
            if (numbers.left == numbers.right) {
                if (indexByNum.containsKey(numbers.left) && indexByNum.get(numbers.left).size() > 1) {
                    return Optional.of(new Pair(indexByNum.get(numbers.left).get(0), indexByNum.get(numbers.left).get(1)));
                }
            } else if (indexByNum.containsKey(numbers.left) && indexByNum.containsKey(numbers.right)) {
                return Optional.of(new Pair(indexByNum.get(numbers.left).get(0), indexByNum.get(numbers.right).get(0)));
            }
            return Optional.empty();
        }
    }

    private static class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    //n2/2 => maxNumber 104^2 / 2 = 5 000 operations
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
