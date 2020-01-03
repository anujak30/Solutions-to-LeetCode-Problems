class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if(s == null || s.length() == 0)
            return 0;
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));
            if(oneDigit >= 1 && oneDigit <= 9)
                dp[i] += dp[i - 1];
            if(twoDigits >= 10 && twoDigits <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
// Runtime: 2 ms, faster than 56.17% of Java online submissions for Decode Ways.
// Memory Usage: 35.7 MB, less than 99.06% of Java online submissions for Decode Ways.
// Khaalcha didn't work
// class Solution {
//     public int numDecodings(String s) {
//         int ways = 1;
//         for(int i = 0; i < s.length() - 1; i++){
//             int currWays = 1;
//             int current = Character.getNumericValue(s.charAt(i));
//             int next = Character.getNumericValue(s.charAt(i + 1));
//             if(current >= 1 && current <= 9){
//                 int nextNumber = current * 10 + next;
//                 if(nextNumber <= 26)
//                     currWays = 2;
//             }
//             ways *= currWays;
//         }
//         return ways;
//     }
// }