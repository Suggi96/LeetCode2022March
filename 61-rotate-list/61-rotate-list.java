/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0)
            return head;
        
        int len = 1;
        ListNode tail = head;
        while(tail.next!=null) {
            tail = tail.next;
            len++;
        }
        if(k>len)
            k = k % len;
        if(k==0 || k==len)
            return head;
        //finding breaking point node 
        int i = 0;
        ListNode newTail = head;
        while(i < (len-k-1)) {
            newTail = newTail.next;
            i++;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        return newHead;
    }
}