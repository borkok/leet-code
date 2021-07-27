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

    public int[] plusOne(int[] digits) {
        return Integer.toString(toInt(digits) + 1)
                      .chars()
                      .map(c -> c - '0')
                      .toArray();
    }

    private int toInt(int[] digits) {
        int result = 0;
        for (int i = 0; i < digits.length; i++) {
            result += digits[i] * Math.pow(10, digits.length - 1 - i);
        }
        return result;
    }
}