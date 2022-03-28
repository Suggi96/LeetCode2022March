class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] ans = new long[n];
        int i = 0;
        int halfPalLen = (intLength+1)/2; //case to handle both odd and even len
        long l = (long)(Math.pow(10, halfPalLen-1)); //10
        long r = (long)(Math.pow(10, halfPalLen)) - 1; // 99
        
        for(int q: queries) {
            long totalCount = r - l + 1;
            if(q<=totalCount) {
                String leftHalf = String.valueOf(l + q  - 1);
                
                String rightHalf = (new                                                StringBuilder(leftHalf)).reverse().toString();
                
                 //now for intLength 4 we have (1001) and 3 we have (1001)
				//we don't need middle value (right half 0 index) if intLength is odd
				ans[i]=Long.valueOf( leftHalf+rightHalf.substring(intLength % 2 ) );
            }
            else{
                ans[i] = -1;
            }
            i++;
        }
        return ans;
    }
}