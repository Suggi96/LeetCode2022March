class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int closestSum = nums[0] + nums[1] + nums[n-1];
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