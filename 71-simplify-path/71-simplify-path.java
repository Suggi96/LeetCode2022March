class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<path.length();i++) {
          
            if(path.charAt(i)=='/') {
                continue;
            }
              String temp = "";
            //build the string
            while(i<path.length() && path.charAt(i)!='/') {
                temp += path.charAt(i);
                i++;
            }
            if(temp.equals(".")) { //do nothing
                continue;
            }
            else if(temp.equals("..")) {
                if(!st.empty()) {
                    st.pop();
                }
            }
            //add word into stack
            else {
                st.push(temp);
            }
        }
        String ans = ""; //generate the absolute path
        while(!st.empty()) {
            ans = "/" + st.peek() + ans;
            st.pop();
        }
        if(ans=="") 
            return "/";
        return ans;
    }
}