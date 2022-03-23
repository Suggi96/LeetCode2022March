class Solution {
    public int maxProfit(int[] prices) {
        int canBuy = 1; //buy only if its 1 otherwise its 0 so sell
         // i am allowed to make unlimited transacn in this problem
        int idx = 0; //we start at index 0
        return maxprofit(idx, canBuy, prices, 
                         new HashMap<String,Integer>());
    }
    private int maxprofit(int idx, int canBuy, int[] prices,
                         HashMap<String, Integer> memo) {
        //base case when idx>=prices.length 
        //I reached index which isnt present in prices array so i cant make any money
        if(idx>=prices.length)
            return 0;
        
        int ans = 0;
        String curKey = idx + "-" + canBuy + "-";
        
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        //always move to next idx no matter what 
        if(canBuy==1) {
            int idle = maxprofit(idx+1, canBuy, prices, memo);
            int buy = -prices[idx] + maxprofit(idx+1, 0, prices,                                                    memo);
                        //-prices: because i am at loss when i buy a stock initially
            ans = Math.max(idle, buy);
        }
        else {
            int idle = maxprofit(idx+1, canBuy, prices, memo);
            //move idx+2 after selling because idx+1 is skipped because of cooldown
            int sell = prices[idx] + maxprofit(idx+2, 1, prices,                                                  memo);
    
            ans = Math.max(idle, sell);
        }
        memo.put(curKey, ans);
        return memo.get(curKey);
    }
}