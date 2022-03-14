class Solution {
    public String reverseWords(String s) {
        String res = "";
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
                res = s.substring(i ,j) + " " + res;
                i = j;
            }
        }
        return res.substring(0, res.length()-1);
    }
}