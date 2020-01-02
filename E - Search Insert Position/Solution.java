class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null)
            return 0;
        int low = 0, high = nums.length - 1, index = -1;  
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target) {
                index = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
                index = low;
            }
        }
        return index;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
// Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Search Insert Position.