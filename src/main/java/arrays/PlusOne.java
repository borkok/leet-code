package arrays;

public class PlusOne {
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
}