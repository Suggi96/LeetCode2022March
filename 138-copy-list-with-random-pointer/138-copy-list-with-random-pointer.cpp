/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node* dummy = new Node(-1);
        Node* cur = head;
        Node* copy = dummy;
        map<Node*, Node*> mp;
        while(cur!=NULL) {
            copy->next = new Node(cur->val);
            copy = copy->next;
            mp[cur] = copy;
            cur = cur->next;
        }
        cur = head;
        copy = dummy->next;
        while(cur!=NULL) {
            copy->random = mp[cur->random];
            copy = copy->next;
            cur = cur->next;
        }
        return dummy->next;
    }
};