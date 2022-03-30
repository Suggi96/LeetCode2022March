class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        //init dp array to -1
        for(int i=0;i<s.length();i++)
            for(int j=0;j<s.length();j++)
                dp[i][j] = -1;
        
        
        return lcs(s, new StringBuilder(s).reverse().toString(), 0, 0, 
                 s.length(), new StringBuilder(s).reverse().toString().length(),
                 dp);
    }
    private int lcs(String s1, String s2, int i, int j, int m, int n,
                   int[][] dp) {
        if(i>=m || j>=n)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans = -1;
        if(s1.charAt(i)==s2.charAt(j)) {
            ans = 1 +  lcs(s1, s2, i+1, j+1, m, n, dp);
            dp[i][j] = ans;
        }
        else {
            int a =  lcs(s1, s2, i, j+1, m, n, dp);
            int b =  lcs(s1, s2, i+1, j, m, n, dp);
            ans = Math.max(a, b);
            dp[i][j] = ans;
        }
        return dp[i][j];
    }
}