/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;   // To avoid overflow
            if(!isBadVersion(mid))
                low = mid + 1;
            else
                high = mid - 1;            
        }
        return low;
    }
}

// Runtime: 10 ms, faster than 99.80% of Java online submissions for First Bad Version.
// Memory Usage: 33.1 MB, less than 100.00% of Java online submissions for First Bad Version.