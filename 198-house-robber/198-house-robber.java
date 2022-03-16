class Solution {
    public int rob(int[] nums) {
        return maxMoney(0, nums, new HashMap<Integer, Integer>());
    }
    private int maxMoney(int curIndex, int[] nums, HashMap<Integer,Integer> memo) {
        if(curIndex>=nums.length)
            return 0;
        
        int curKey = curIndex;
        if(memo.containsKey(curKey)) {
            return memo.get(curKey);
        }
        
        int rob = nums[curIndex] + maxMoney(curIndex+2, nums, memo);
        int noRob = maxMoney(curIndex+1, nums, memo);
        
        memo.put(curKey, Math.max(rob, noRob));
        
        return memo.get(curKey);
    }
}