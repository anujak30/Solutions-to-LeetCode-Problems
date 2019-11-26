/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = head;
        ListNode curr; 
        if(head != null)
            curr = head.next;
        else
            return head;
        //Handling special case
        while(prev != null && prev.val == val)
            prev = prev.next;
        if(prev != null){
            curr = prev.next;
            head = prev;
        }
        else
            return null;
        while(curr != null){
            if(curr.val == val)
                prev.next = curr.next;
            else
                prev = prev.next;
            curr = curr.next;
        }
        return head;
    }
}
// Runtime: 1 ms, faster than 98.66% of Java online submissions for Remove Linked List Elements.
// Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Remove Linked List Elements.