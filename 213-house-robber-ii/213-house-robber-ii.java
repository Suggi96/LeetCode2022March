class Solution {
    public int rob(int[] nums) {
        //rob from index 0 to n-2 ==> ans1
        //rob from index 1 to n-1 ==> ans2
        //now problem gets converted to house robber 1
        //return max(ans1, ans2) 
        int n = nums.length;
        if(n==1) //if single house is present return  nums[0] as ans
            return nums[0];
        int ans1 = maxMoney(0, n-2, nums, new HashMap<Integer, Integer>());
        int ans2 = maxMoney(1, n-1, nums, new HashMap<Integer, Integer>());
        return Math.max(ans1, ans2);
    }
    private int maxMoney(int curIndex, int lastIdx, int[] nums,
                         HashMap<Integer, Integer> memo) {
        if(curIndex>lastIdx) {
            return 0;
        }
        int curKey = curIndex;
        
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int rob = nums[curIndex] + maxMoney(curIndex+2,lastIdx, nums, memo);
        int norob = maxMoney(curIndex+1,lastIdx, nums, memo);
        
        memo.put(curKey, Math.max(rob, norob));
        
        return memo.get(curKey);
    }
}