class Solution {
    public boolean canJump(int[] nums) {
        int farest = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(i>farest)
                return false;
            farest = Math.max(farest, i+nums[i]);
        }
        return true;
    }
}