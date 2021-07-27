package arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        //awful O(3n+n2) solution
        //return awfulIntersect(nums1, nums2);

        //3n to make list from array and array from list, 2*n logn to sort
        return sortedIntersect(nums1, nums2);
    }

    private int[] sortedIntersect(int[] nums1, int[] nums2) {
        List<Integer> left = makeList(nums1);
        left.sort(Comparator.naturalOrder());
        List<Integer> right = makeList(nums2);
        right.sort(Comparator.naturalOrder());

        List<Integer> result = new LinkedList<>();
        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            Integer intLeft = left.get(leftIndex);
            Integer intRight = right.get(rightIndex);
            if (intLeft.equals(intRight)) {
                result.add(intLeft);
                leftIndex++;
                rightIndex++;
            }
            if (intLeft > intRight) {
                rightIndex++;
            }
            if (intLeft < intRight) {
                leftIndex++;
            }
        }

        return makeArray(result);
    }

    private List<Integer> makeList(int[] nums) {
        List<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            result.add(nums[i]);
        }
        return result;
    }

    private int[] makeArray(List<Integer> integers1) {
        int[] ints = new int[integers1.size()];
        for (int i = 0; i < integers1.size(); i++) {
            ints[i] = integers1.get(i);
        }
        return ints;
    }

    private int[] awfulIntersect(int[] nums1, int[] nums2) {
        List<Integer> integers1 = makeList(nums1);
        List<Integer> integers2 = makeList(nums2);
        integers1.retainAll(integers2);
        return makeArray(integers1);
    }
}