class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        int n = nums.size();
        if(n<=2)    
            return 0;
        int cur = 0, ans = 0;
        for(int i=2;i<n;i++) {
            if(nums[i-1] - nums[i-2] == nums[i] - nums[i-1]) {
                cur += 1;
                ans += cur;
            }
            else {
                cur = 0;
            }
        }
        return ans;
    }
};