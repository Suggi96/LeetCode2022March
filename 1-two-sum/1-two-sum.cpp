class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        map<int, int> mp;
        for(int i=0;i<nums.size();i++) {
            int x = target - nums[i];
            if(mp.find(x)!=mp.end()) {
                ans.push_back(i);
                ans.push_back(mp[x]);
                return ans;
            }
            else {
                mp[nums[i]] = i;
            }
        }
        return ans;
    }
};