class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int zeroIndex = minCost(0, n, cost, new HashMap<Integer, Integer>());
        int firstIndex = minCost(1, n, cost, new HashMap<Integer, Integer>());
        
        return Math.min(zeroIndex, firstIndex);
    }
    private int minCost(int curIndex, int n, int[] cost, 
                        HashMap<Integer, Integer> memo) {
        //base case
        if(curIndex==n) {
            return 0;
        }
        if(curIndex>n) {
            return 1001;
        }
        
        int curKey = curIndex;
        if(memo.containsKey(curKey)) {
            return memo.get(curKey);
        }
        
        int oneJump = cost[curKey] + minCost(curKey+1, n, cost, memo);
        int twoJumps = cost[curKey] + minCost(curKey+2, n, cost, memo);
        
        memo.put(curKey, Math.min(oneJump, twoJumps));
        
        return memo.get(curKey);
    } 
}