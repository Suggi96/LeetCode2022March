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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        Map<Integer, Integer> map = new TreeMap<>();
        ListNode cur = head;
        while(cur!=null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0)+1);
            cur = cur.next;
        }
        cur = null;
        ListNode newHead = new ListNode(-999);
        
        boolean firstNode = false;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue()==1) {
               if(firstNode==false) {
                newHead.val = e.getKey();
                firstNode = true;
                cur = newHead;
            } 
                else {
                ListNode temp = new ListNode(e.getKey());
                cur.next = temp;
                cur = cur.next;
            }
                
     }
            
        }
        if(newHead.val==-999)
            return null;
        return newHead;
    }
}