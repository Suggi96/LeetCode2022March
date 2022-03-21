class Solution {
    public int change(int amount, int[] coins) {
       return totalWays(0, amount, coins, new HashMap<String, Integer>()); 
    }
    
    private int totalWays(int idx, int amount, int[] coins,
                         HashMap<String, Integer> memo) {
        if(idx==coins.length)
            return 0;
        
        if(amount==0)
            return 1;
        
        String curKey = idx + "-" + amount;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int consider = 0;
        if(coins[idx]<=amount) 
            consider = totalWays(idx, amount-coins[idx], coins, memo);
        
        int notconsider = totalWays(idx+1, amount, coins, memo);
        
        memo.put(curKey, consider+notconsider);
        
        return memo.get(curKey);
        
    }
}