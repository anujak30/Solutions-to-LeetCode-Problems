class Solution {
    public int[] plusOne(int[] digits) {
        boolean extraDigit = false;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            if(i == digits.length - 1)
                digits[i]++;
            digits[i] += carry;
            if(digits[i] > 9) {
                digits[i] = 0;
                carry = 1;
            }
            else 
                carry = 0;
        }
        if(carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        else
            return digits;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
// Memory Usage: 35.3 MB, less than 97.58% of Java online submissions for Plus One.