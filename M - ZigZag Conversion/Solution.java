class Solution {
    public String convert(String s, int numRows) {
        int str_length = s.length();
        int index;
        int twiceNumRowsMinusTwo = 2 * numRows - 2;
        int jumps = twiceNumRowsMinusTwo;
        String answer = "";
        if(numRows == 1)
            return s;
        for(int i = 0; i < numRows; i++){
            index = i;
            jumps = twiceNumRowsMinusTwo - (2 * (i));
            while(index < str_length){
                if(jumps != 0){
                    answer = answer + s.charAt(index);
                    index += jumps;
                }
                jumps = twiceNumRowsMinusTwo - jumps;
            }
            jumps -= 2;
        }
        return answer;
    }
}
// class Solution {
//     public String convert(String s, int numRows) {
//         int str_length = s.length();
//         int index, oldIndex = -1;
//         int left = 2 * numRows - 2, right = 0;
//         String answer = "";
//         if(s == null || s.length() == 0)
//             return answer;
//         if(numRows == 1)
//             return s;
//         for(int i = 0; i < numRows; i++){
//             index = i;
//             int times = 0;
//             while(index < str_length){
//                 if(oldIndex != index)
//                     answer = answer + s.charAt(index);
//                 oldIndex = index;
//                 if(times % 2 == 0)
//                     index += left;
//                 else
//                     index += right;
//                 times++;
//             }
//             left -= 2;
//             right += 2;
//         }
//         return answer;
//     }
// }