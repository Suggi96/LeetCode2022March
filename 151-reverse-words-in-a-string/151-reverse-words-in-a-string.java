class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        int i = 0;
        int n = s.length();
        while(i<n) {
            if(s.charAt(i)==' ') {
                i++;
                continue;
            }
            else if(s.charAt(i)!=' ') {
                int j = i;
                while(j<n && s.charAt(j)!=' ') j++;
                st.push(s.substring(i ,j));
                i = j;
            }
        }
        String res = "";
        while(!st.isEmpty()) {
            res =  res + " " + st.pop();
        }
        return res.substring(1, res.length());
    }
}