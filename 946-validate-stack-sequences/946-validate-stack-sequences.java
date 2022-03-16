class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int cur = 0; //pointer to iterate popped array
        for(int i=0;i<pushed.length;i++) {
            st.push(pushed[i]);
            while(!st.empty() && st.peek()==popped[cur]) {
                st.pop();
                cur++;
            }
                
        }
        if(st.empty())
            return true;
        return false;
    }
}