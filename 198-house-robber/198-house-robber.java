class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        return maxMoney(0, n-1, nums, new HashMap<Integer, Integer>());
    }
    private int maxMoney(int curIndex, int lastIdx, int[] nums,                                         HashMap<Integer,Integer> memo) {
        if(curIndex>lastIdx)
            return 0;
        
        int curKey = curIndex;
        if(memo.containsKey(curKey)) {
            return memo.get(curKey);
        }
        
        int rob = nums[curIndex] + maxMoney(curIndex+2, lastIdx, nums, memo);
        int noRob = maxMoney(curIndex+1, lastIdx, nums, memo);
        
        memo.put(curKey, Math.max(rob, noRob));
        
        return memo.get(curKey);
    }
}