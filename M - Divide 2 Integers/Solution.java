// Accepted
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Divide Two Integers.
// Memory Usage: 33.7 MB, less than 6.06% of Java online submissions for Divide Two Integers.
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if((dividend ^ divisor) >= 0){     
            sign = 1;
        }
        else{
            sign = -1;
        }
        divisor = divisor < 0 ? divisor : -divisor;
        dividend = dividend < 0 ? dividend : -dividend;
        int a = dividend, b = divisor;
        int ans = 0;
        while(a <= divisor){
            boolean ob = false;
            while(a <= b){
                if(b * 2 >= 0){  // overflow, don't forget to include 0 here
                    ob = true;
                    break;
                }
                b = b * 2;
            }
            b = ob ? b : b/2;
            ans += b/divisor;
            a = a - b;
            b = divisor;
        }
        return ans*sign;
    }
}
// TLE late
class Solution {
    public int divide(int dividend, int divisor) {
        int quotient = 0;
        boolean positive = true;
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        else if(dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;
        if(dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0)
            positive = true;
        else
            positive = false;
        long div = Math.abs((long)dividend);
        long divisor1 = Math.abs((long)divisor);
        while(div >= divisor1){
            div -= divisor1;
            quotient++;
        }
        if(!positive)
            quotient = -quotient;
        return quotient;
    }
}
// TLE Laukar
class Solution {
    public int divide(int dividend, int divisor) {
        int quotient = 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        else if(dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while((dividend - divisor) >= 0){
            int x = 0;
            while(((dividend - divisor) << 1 << x) >= 0)
                x++;
            quotient = quotient + x;
            dividend = divisor << x;
        }
        return quotient;
    }
}