package arrays;

import java.util.HashSet;

public class Solution {
    public void rotate(int[] nums, int shift) {
        if (nums.length <= 1)   return;
        if (shift <= 0)             return;

        int k = shift % nums.length;
        if (k == 0)   return;

        int headLen = nums.length - k;
        int[] head = new int[headLen];
        System.arraycopy(nums, 0, head, 0, headLen);

        for (int i = 0; i < k; i++) {
            nums[i] = nums[headLen + i];
        }
        for (int i = 0; i < headLen; i++) {
            nums[k + i] = head[i];
        }
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!integers.add(nums[i])) return true;
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        //had to peek solution :(
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }

    /**
     * 1 <= digits.length <= 100
     *
     */
    public int[] plusOne(int[] digits) {
        if (isAllNines(digits)) {
            //init result to all zeros
            //we need one extra most significant digit
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        //init result to all zeros
        int[] result = new int[digits.length];
        //start from least significant digit
        int index = digits.length - 1;
        //all nines turn to 0 in result (2999 => 3000)
        while (index >= 0 && digits[index] == 9) {
            index--;
        }
        //add one
        result[index] = digits[index] + 1;
        //copy the rest of digits
        index--;
        while (index >= 0) {
            result[index] = digits[index];
            index--;
        }
        return result;
    }

    private boolean isAllNines(int[] digits) {
        for (int digit : digits) {
            if (digit != 9) return false;
        }
        return true;
    }

    /*
        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1
        Note that you must do this in-place without making a copy of the array.
     */
    public void moveZeroes(int[] nums) {
        if (nums.length > 1 && hasAnyZero(nums)) {
            int leftZero = -1;
            int rightZero = -1;
            for (int i = 0; i < nums.length || rightZero >= nums.length; i++) {
                if (nums[i] == 0) {
                    if (leftZero < 0) {
                        leftZero = i;
                    }
                    rightZero = i;
                } else if (leftZero >= 0) {
                    nums[leftZero] = nums[i];
                    nums[i] = 0;
                    leftZero++;
                    rightZero++;
                }
            }
        }
    }

    private boolean hasAnyZero(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) return true;
        }
        return false;
    }
}