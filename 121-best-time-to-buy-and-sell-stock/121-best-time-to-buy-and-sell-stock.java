class Solution {
    public int maxProfit(int[] prices) {
        int canBuy = 1; //buy only if its 1 otherwise its 0 so sell
        int transactionCount = 1; // i am allowed to make 1 transacn in this problem
        int idx = 0; //we start at index 0
        return maxprofit(idx, canBuy, transactionCount, prices, 
                         new HashMap<String,Integer>());
    }
    private int maxprofit(int idx, int canBuy, int transactionCount, int[] prices,
                         HashMap<String, Integer> memo) {
        //base case when idx>=prices.length or transactionCount is 0 
        //I return 0 because impossible to make money when i dont have transaction count          // or reached index which isnt present in prices array
        if(idx>=prices.length || transactionCount==0)
            return 0;
        
        int ans = 0;
        String curKey = idx + "-" + canBuy + "-" + transactionCount;
        
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        //always move to next idx no matter what 
        if(canBuy==1) {
            int idle = maxprofit(idx+1, canBuy, transactionCount, prices, memo);
            int buy = -prices[idx] + maxprofit(idx+1, 0, transactionCount, prices,                                                    memo);
                        //-prices because i am at loss when i buy a stock initially
            ans = Math.max(idle, buy);
        }
        else {
            int idle = maxprofit(idx+1, canBuy, transactionCount, prices, memo);
            int sell = prices[idx] + maxprofit(idx+1, 1, transactionCount-1, prices,                                                  memo);
            //we subtracted transactionCount - 1 indicating transaction is done
            ans = Math.max(idle, sell);
        }
        memo.put(curKey, ans);
        return memo.get(curKey);
    }
}