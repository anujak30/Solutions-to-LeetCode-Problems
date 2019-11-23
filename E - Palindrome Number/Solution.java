class Solution {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        if(x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int xCopy = x;
        while(x > 0){
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }
        if(reverse == xCopy)
            return true;
        else
            return false;
    }
}