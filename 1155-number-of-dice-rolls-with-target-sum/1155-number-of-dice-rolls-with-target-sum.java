class Solution {
    int mod = (int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        HashMap<String, Integer> memo = new HashMap<>();
        return totalWays(n, k, target, memo);
    }
    private int totalWays(int n, int f, int targetSum, HashMap<String, Integer> memo) {
        if(n==0 && targetSum==0)
            return 1;
        
        if(n==0 || targetSum<0)
            return 0;
        String curKey = n + "-" + targetSum;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        int ways = 0;
        for(int i=1;i<=f;i++) {
            int tempAns = totalWays(n-1, f, targetSum-i, memo) % mod;
            ways = ways % mod;
            ways = (ways+tempAns) % mod;
        }
        memo.put(curKey, ways);
        return memo.get(curKey);
    }
}