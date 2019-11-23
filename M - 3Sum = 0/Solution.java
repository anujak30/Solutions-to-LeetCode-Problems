class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                int wanted = (nums[i] + nums[j]) * (-1);
                int lastIndex = lastIndexOf(wanted, nums);
                if(lastIndex != i && lastIndex != j && lastIndex != -1){
                    List<Integer> subAnswer = new ArrayList<Integer>();
                    subAnswer.add(nums[i]);
                    subAnswer.add(nums[j]);
                    subAnswer.add(wanted);
                    Collections.sort(subAnswer);
                    if(!answer.contains(subAnswer))
                        answer.add(subAnswer);
                }
            }
        }
        return answer;
    }
    public int lastIndexOf(int wanted, int[] nums){
        for(int i = nums.length - 1; i >= 0; i--)
            if(wanted == nums[i])
                return i;
        return -1;
    }
}
// The upper on is with less space
//Still time limit eceeded for both
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> answer = new ArrayList<List<Integer>>();
//         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//         for(int i = 0; i < nums.length; i++){
//             if(map.containsKey(nums[i])) 
//                 map.put(nums[i], (map.get(nums[i]) + 1));
//             else
//                 map.put(nums[i], 1);
//         }
//         for(int i = 0; i < nums.length - 2; i++){
//             for(int j = i + 1; j < nums.length - 1; j++){
//                 map.put(nums[i], (map.get(nums[i]) - 1));
//                 map.put(nums[j], (map.get(nums[j]) - 1));
//                 int wanted = (nums[i] + nums[j]) * (-1);
//                 if(map.containsKey(wanted) && map.get(wanted) >= 1){
//                     List<Integer> subAnswer = new ArrayList<Integer>();
//                     subAnswer.add(nums[i]);
//                     subAnswer.add(nums[j]);
//                     subAnswer.add(wanted);
//                     Collections.sort(subAnswer);
//                     if(!answer.contains(subAnswer))
//                         answer.add(subAnswer);
//                 }
//                 map.put(nums[i], map.get(nums[i]) + 1);
//                 map.put(nums[j], map.get(nums[j]) + 1);
//             }
//         }
//         return answer;
//     }
// }