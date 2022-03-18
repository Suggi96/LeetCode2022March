class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        //find lastIndex of each char and store in lastIndex[]
        for(int i=0;i<s.length();i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(seen[c - 'a']==true) //indicates element already in stack so do nothing
                continue;
            
            //popping rules
            while(!st.empty() && st.peek()>c && i < lastIndex[st.peek() - 'a']) {
                seen[st.pop() - 'a'] = false;
            }
            //push cur element to stack
            st.push(c);
            seen[c - 'a'] = true;
        }
       //pop elements from stack and reverse the string and return it
        StringBuilder str = new StringBuilder();
        while(!st.empty()) {
         //   int popped = st.peek();
            str.append(st.peek());
            st.pop();
        }
        return str.reverse().toString();
    }
}