class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<List<Integer>> answer = new  ArrayList<List<Integer>>();
        
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.replace(nums[i], map.get(nums[i]) + 1);
        }
        for(int i = 0; i < nums.length - 2; i++){
            map.replace(nums[i], map.get(nums[i]) - 1);
            for(int j = i + 1; j < nums.length - 1; j++){
                map.replace(nums[j], map.get(nums[j]) - 1);    
                for(int k = j + 1; k < nums.length; k++){
                    map.replace(nums[k], map.get(nums[k]) - 1);
                    int complement = target - nums[i] - nums[j] - nums[k];
                    if(map.containsKey(complement) && map.get(complement) > 0){
                        List<Integer> subAnswer = new ArrayList<Integer>();
                        subAnswer.add(nums[i]);
                        subAnswer.add(nums[j]);
                        subAnswer.add(nums[k]);
                        subAnswer.add(complement);
                        Collections.sort(subAnswer);
                        if(!answer.contains(subAnswer))
                            answer.add(subAnswer);
                    }
                    map.replace(nums[k], map.get(nums[k]) + 1);
                }
                map.replace(nums[j], map.get(nums[j]) + 1);
            }
            map.replace(nums[i], map.get(nums[i]) + 1);
        }
        return answer;
    }
}
// Runtime: 371 ms, faster than 5.06% of Java online submissions for 4Sum.
// Memory Usage: 53.9 MB, less than 13.04% of Java online submissions for 4Sum.