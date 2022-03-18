class Solution {
    public boolean canPartition(int[] nums) {
       HashMap<String, Boolean> memo = new HashMap<String, Boolean>();
        int sum = 0;
        for(int i: nums) 
            sum+=i;
        if(sum%2==1)
            return false;
        return part(0, sum/2, nums, memo);
        
    }
    private boolean part(int curIdx, int sum, int[] nums, 
                         HashMap<String, Boolean> memo) {
        if(curIdx>=nums.length)
            return false;
        if(sum==0)
            return true;
        
        boolean pickCurElement = false;
        boolean noPickCurElement = false;
        
        String curKey = Integer.toString(curIdx) + "-" + Integer.toString(sum);
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        if(nums[curIdx]<=sum) {
            pickCurElement = part(curIdx+1, sum-nums[curIdx], nums, memo);
        }
        if(pickCurElement!=true)
        noPickCurElement = part(curIdx+1, sum, nums, memo);
        
        memo.put(curKey, pickCurElement || noPickCurElement);
        return memo.get(curKey);
    }
}