class Solution {
    public int maxProfit(int[] prices, int fee) {
        int canBuy = 1; //buy only if its 1 otherwise its 0 so sell
        int idx = 0; //we start at index 0
        return maxprofit(idx, canBuy, prices, fee 
                         ,new HashMap<String,Integer>());
    }
    private int maxprofit(int idx, int canBuy, int[] prices,
                         int fee, HashMap<String, Integer> memo) {
        //idx crosses last index of array return 0 because no profit
        if(idx>=prices.length)
            return 0;
        
        int ans = 0;
        String curKey = idx + "-" + canBuy;
        
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        //always move to next idx no matter what 
        if(canBuy==1) {
            int idle = maxprofit(idx+1, canBuy, prices,fee, memo);
            int buy = -prices[idx] + maxprofit(idx+1, 0, prices                                                    ,fee, memo);
                        //-prices because i am at loss when i buy a stock initially
            ans = Math.max(idle, buy);
        }
        else {
            int idle = maxprofit(idx+1, canBuy, prices, fee, memo);
            int sell = -fee + prices[idx] + maxprofit(idx+1, 1,                                                          prices, fee, memo);
            ans = Math.max(idle, sell);
        }
        memo.put(curKey, ans);
        return memo.get(curKey);
    }
}