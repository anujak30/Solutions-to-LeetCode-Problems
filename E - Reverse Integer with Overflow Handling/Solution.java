
class Solution {
    public int reverse(int x) {
        int reverse = 0;
        int negative = 0;
        if(x < 0){
            negative = 1;
            x *= -1;
        }
        while(x > 0){
            if(reverse > Integer.MAX_VALUE/10)
                return 0;
            else{
                reverse *= 10;
                if((reverse + (x % 10)) > Integer.MAX_VALUE)
                    return 0;
                else{
                    reverse += (x % 10);   
                }
            }
            x /= 10;
        }
        if(negative == 1)
            reverse *= -1;
        return reverse;
    }
}