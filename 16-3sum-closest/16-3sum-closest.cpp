class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        if(nums.size() < 3) return 0;
        int closestSum = nums[0]+nums[1]+nums[2];
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int curSum = 0;
        for(int i=0;i<n-2;i++) {
            int start = i+1;
            int end = n-1;
            while(start<end) {
                curSum = nums[i] + nums[start] + nums[end];
                if(curSum < target) {
                    start++;
                }
                else {
                    end--;
                }
                 if(abs(curSum - target) < abs(closestSum - target)) {
                    closestSum = curSum;
                 }
            }
        }
        return closestSum;
    }
};