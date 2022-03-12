/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node cur = head, copy = dummy;
        Map<Node, Node> map = new HashMap();
        while(cur!=null) {
            copy.next = new Node(cur.val);
            copy = copy.next;
            map.put(cur, copy);
            cur = cur.next;
        }
        cur = head;
        copy = dummy.next;
        while(cur!=null) {
            copy.random = map.get(cur.random);
            copy = copy.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}