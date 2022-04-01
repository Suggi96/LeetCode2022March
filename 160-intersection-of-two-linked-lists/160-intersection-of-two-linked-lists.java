/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode startA = headA;
        ListNode startB = headB;
        while(startA!=startB) {
            if(startA==null) {
                startA = headB;
            }
            else {
                startA = startA.next;
            }
            if(startB==null) {
                startB = headA;
            }
            else {
                startB = startB.next;
            }
        } 
        return startA;
    }
}