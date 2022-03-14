class Solution {
    public String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> st = new Stack<>();
        
        for(int i=0;i<s.length;i++) {
           if(!st.isEmpty() && s[i].equals("..")) st.pop();
            else if(!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                st.push(s[i]);
        }
        if(st.size()==0)
            return "/";
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.insert(0, st.pop()).insert(0, "/");
        }
        return ans.toString();
    }
}