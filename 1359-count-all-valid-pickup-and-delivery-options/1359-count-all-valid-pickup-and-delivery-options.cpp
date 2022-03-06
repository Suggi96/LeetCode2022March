class Solution {
public:
    int countOrders(int n) {
        int mod = 1e9 + 7;
        long dp[501] = {0};
        dp[1] = 1l;
        dp[2] = 6l;
        for(int i=3;i<=n;i++) {
            int oddNo = 2*i - 1;
            int permutations = oddNo * (oddNo+1)/2;
            dp[i] = (dp[i-1] *  permutations) % mod;
        }
        return (int)dp[n];
    } 
};