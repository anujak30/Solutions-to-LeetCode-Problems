class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        if(nums.length == 0)
            return 0;
        while(j < nums.length){
            if(nums[i] != val){
                i++;
                j++;
            }
            else
                break;
        }
        while(j < nums.length){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
            j++;    
        }
        return i;
    }
}
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
// Memory Usage: 35.2 MB, less than 100.00% of Java online submissions for Remove Element.