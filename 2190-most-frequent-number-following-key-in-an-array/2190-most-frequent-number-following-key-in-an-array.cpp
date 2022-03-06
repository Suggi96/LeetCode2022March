class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        unordered_map<int, int> mp;
        for(int i=0;i<nums.size()-1;i++) {
            if(nums[i]==key) {
                mp[nums[i+1]]++;
            }
        }
        int max = INT_MIN;
        int target = 0;
        for(auto it: mp) {
            if(it.second > max) {
                target = it.first;
                max = it.second;
            }
        }
        return target;
    }  
};