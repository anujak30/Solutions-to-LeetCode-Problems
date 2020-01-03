// Single pass constant space

public class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r; i++) {
            if (nums[i] == 0)
                swap(nums, i, l++);
            else if (nums[i] == 2)
                swap(nums, i--, r--);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
// Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Sort Colors.


// Counting Sort: Uses extra space

class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int num : nums) 
            count[num]++;
        int index = 0;
        for(int i = 0; i < count.length; i++) {
            for(int j = 0; j < count[i]; j++) 
                nums[index++] = i;
        }
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
// Memory Usage: 35.4 MB, less than 99.21% of Java online submissions for Sort Colors.