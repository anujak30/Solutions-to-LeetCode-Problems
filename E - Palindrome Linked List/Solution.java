/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int number = 0, reverse = 0, length = 0;
        ListNode traversal = head;
        while(traversal != null){
            length++;
            traversal = traversal.next;
        }
        if(length == 0 || length == 1)
            return true;
        ArrayList<Integer> array = new ArrayList<Integer>();
        int i = 1;
        traversal = head;
        float len = (float) length/2;
        while(i <= Math.ceil(len)){
            array.add(traversal.val);
            traversal = traversal.next;
            i++;
        }
        boolean flag = false;
        int counter = length - i;
        while(counter >= 0){
            if(array.get(counter) == traversal.val){
                flag = true;
                traversal = traversal.next;
                counter--;
            }
            else
                return false;
        }
        return flag;
    }
}
// Runtime: 2 ms, faster than 38.90% of Java online submissions for Palindrome Linked List.
// Memory Usage: 40 MB, less than 98.78% of Java online submissions for Palindrome Linked List.