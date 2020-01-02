/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low <= high) {
            int mid = low + (high - low) / 2; //6 + 2
            int result = guess(mid);
            if(result == 0)
                return mid;
            else if(result == -1)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 1;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
// Memory Usage: 32.9 MB, less than 100.00% of Java online submissions for Guess Number Higher or Lower.