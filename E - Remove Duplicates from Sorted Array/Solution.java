class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        if(nums.length == 0 || nums.length == 1)
            return nums.length;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
// Memory Usage: 39.1 MB, less than 99.47% of Java online submissions for Remove Duplicates from Sorted Array.