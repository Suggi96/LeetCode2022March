class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3) 
            return 0;
       int cur = 0, ans = 0;
        for(int i=2;i<n;i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                cur += 1;
                ans += cur;
            }
            else {
                cur = 0;
            }
        }
        return ans;
    }
}