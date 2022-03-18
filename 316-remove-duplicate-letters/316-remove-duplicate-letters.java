class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] seen = new boolean[26];
        //find lastIndex of each char and store in lastIndex[]
        for(int i=0;i<s.length();i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            int c = s.charAt(i) - 'a';
            if(seen[c]==true) //indicates element already in stack so do nothing
                continue;
            
            //popping rules
            while(!st.empty() && st.peek()>c && i < lastIndex[st.peek()]) {
                seen[st.pop()] = false;
            }
            //push cur element to stack
            st.push(c);
            seen[c] = true;
        }
       //pop elements from stack and reverse the string and return it
        StringBuilder str = new StringBuilder();
        while(!st.empty()) {
            int popped = st.peek();
            str.append((char)(popped + 'a'));
            st.pop();
        }
        return str.reverse().toString();
    }
}