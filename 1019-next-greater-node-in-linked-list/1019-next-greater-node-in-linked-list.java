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
    public int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while(cur!=null) {
            cur = cur.next;
            len++;
        }
        int ans[] = new int[len];
        int idx = 0;
        cur = head;
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        while(cur!=null) {
            if(st.empty() || st.peek().getKey()>=cur.val) {
                st.push(new Pair<Integer, Integer>(cur.val, idx++));
            }
            else {
                while(!st.empty() && st.peek().getKey()<cur.val) {
                    int i = st.peek().getValue();
                    ans[i] = cur.val;
                    st.pop();
                }
                st.push(new Pair<Integer, Integer>(cur.val, idx++));
            }
            
            cur = cur.next;
        }
        return ans;
    }
}