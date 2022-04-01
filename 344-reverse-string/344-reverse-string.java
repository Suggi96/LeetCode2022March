class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start<end) {
            char c = s[end];
            s[end] = s[start];
            s[start] = c;
            start++;
            end--;
        }
    }
}