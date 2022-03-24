class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int bought = prices[0];
        for(int i=1; i<prices.length;i++) {
            if(prices[i]>=bought) {
                profit += prices[i] - bought;
            }
            bought = prices[i];
           
        }
        return profit;
    }
}