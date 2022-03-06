class Solution {
    public int countOrders(int n) {
        int mod = (int)(1e9 + 7);
        long dp[] = new long[501];
        dp[1] = 1L;
        dp[2] = 6L;
        for(int i=3;i<=n;i++) {
            int oddNo = 2*i - 1;
            int permutations = oddNo * (oddNo+1)/2;
            dp[i] = (dp[i-1] *  permutations) % mod;
        }
        return (int)dp[n];
    }
}