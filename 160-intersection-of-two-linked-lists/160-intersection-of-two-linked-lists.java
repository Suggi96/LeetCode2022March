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
        if(headA==null || headB==null) return null;
        ListNode cur = headA;
        int x = 0, y=0;
        while(cur!=null) {
            x++;
            cur = cur.next;
        }
         cur = headB;
        while(cur!=null) {
            y++;
            cur = cur.next;
        }
        ListNode startA = headA;
        ListNode startB = headB;
        if(x>y) {
            int diff = x - y;
            while(diff!=0) {
                startA = startA.next;
                diff--;
            }
        }
        else {
            int diff = y - x;
            while(diff!=0) {
                startB = startB.next;
                diff--;
            }
        }
        while(startA!=startB) {
            startA = startA.next;
            startB = startB.next;
        }
        return startA;
    }
}