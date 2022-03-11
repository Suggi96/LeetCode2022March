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
        if(head==null || k==0) 
            return head;
        ListNode tail = head;
        int length = 0;
        while(tail.next!=null) {
            tail = tail.next;
            length++;
        }
        length++;
        int rotateBy = length - k % length; // precedence of % > - So 3 - 4 % 3 = 2
        //create cycle by connecting tail to head
        tail.next = head;
        
        tail = head;
        //move tail to rotateBy positions
        while(rotateBy-- > 1) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
}