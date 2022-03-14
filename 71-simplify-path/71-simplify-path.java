class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] pathList = path.split("\\/");
        for(String p: pathList) {
            if(p.length()==0 || p.equals(".")) {
                continue;
            }
            else if(p.equals("..")) {
                if(!st.empty()) {
                    st.pop();
                }
            }
            //string case
            else {
                st.push(p);
            }
        }
        String ans = "";
        while(!st.empty()) {
            ans = st.pop() + "/" + ans;
        }
        if(ans.length()==0)
            return "/";
        
        return "/" + ans.substring(0, ans.length()-1);                                       
    }
}