class Solution {
    public String getSmallestString(int n, int k) {
        char[] c = new char[n];
        for(int i=0;i<n;i++) {
            c[i] = 'a';
            k = k - 1;
        }
        int idx = n-1;
        while(k>0) {
            int val = Math.min(25, k);
            c[idx] = (char)(val + 'a');
            idx--;
            k = k - val;
        }
        return new String(c);
    }
}