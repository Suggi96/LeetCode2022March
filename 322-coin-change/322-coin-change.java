class Solution {
    public int coinChange(int[] coins, int amount) {
        int ways = minWays(0, amount, coins, new HashMap<String, Integer>());
        if(ways==10000)
            return -1;
        return ways;
    }
    private int minWays(int curIdx, int amount, int[] coins,
                       HashMap<String, Integer> memo) {
        if(curIdx>=coins.length)
            return 10000;
        
        if(amount==0)
            return 0;
        
        String curKey = curIdx + "-" + amount;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int consider = 10000;
        if(coins[curIdx]<=amount)
            consider = 1 + minWays(curIdx, amount - coins[curIdx], coins, memo);
        
        int notConsider = minWays(curIdx+1, amount, coins, memo);
        
        memo.put(curKey, Math.min(consider, notConsider));
        return memo.get(curKey);
    }
}