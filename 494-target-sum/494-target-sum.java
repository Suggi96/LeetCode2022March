class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> memo = new HashMap<>();
        int curSum = 0;
        int curIdx = 0;
        return findWays(curIdx, curSum, nums, target, memo);
    }
    private int findWays(int curIdx,int curSum, int[] nums, int target, 
                        HashMap<String, Integer> memo) {
        if(curIdx==nums.length) {
            if(curSum==target)
                return 1;
            else 
                return 0;
        }
        
        String curKey = Integer.toString(curIdx) + "-" + Integer.toString(curSum);
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int addPlus = findWays(curIdx+1, curSum-nums[curIdx], nums, target, memo);
        int addMinus = findWays(curIdx+1, curSum+nums[curIdx], nums, target, memo);
        
        memo.put(curKey, addPlus + addMinus); //total ways
        
        return memo.get(curKey);
    }
}