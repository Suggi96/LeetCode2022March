class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        int n = nums.length;
        if(n==1)
            return true;
        for(int i=0;i<n-1;i++) {
            if(i>reach) break;
            reach = Math.max(reach, i+nums[i]);
            if(reach>=n-1) return true;
        }
        return false;
    }
}