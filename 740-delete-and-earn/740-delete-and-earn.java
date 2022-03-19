class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10002];
        for(int i=0;i<nums.length;i++) {
            freq[nums[i]]++;
        }
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return maxPoints(0, freq, memo); // 0-> cur idx
    } 
    private int maxPoints(int curIdx, int[] freq, HashMap<Integer, Integer> memo) {
        if(curIdx >= freq.length) {
            return 0;
        }
        int curKey = curIdx;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int del = curIdx*freq[curIdx] + maxPoints(curIdx+2, freq, memo);
        int nodel = maxPoints(curIdx+1, freq, memo);
        
        memo.put(curKey, Math.max(del, nodel));
        return memo.get(curKey);
    }
}