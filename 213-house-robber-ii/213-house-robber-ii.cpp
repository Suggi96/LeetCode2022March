class Solution {
public:
   int rob(vector<int>& nums) {
        int n = nums.size();
        
        // Edge case
        if(n < 2) return n ? nums[0] : 0;
        
        map<int, int> memo;
        map<int, int> memo1;
        return max(findMaxMoney(0, nums, n-2, memo), findMaxMoney(1, nums, n-1, memo1));
    }

int findMaxMoney(int currentHouse, vector<int>& nums, int n, map<int, int>& memo){
        // Its greater or eqal so if CH reaches at last house, it will return 0
        if(currentHouse > n)
            return 0;
        
        int currentKey = currentHouse;
        if(memo.count(currentKey) > 0)
            return memo[currentKey];
        
        int pickHouse = nums[currentHouse] + findMaxMoney(currentHouse+2, nums, n, memo);
        int notPickHouse = findMaxMoney(currentHouse+1, nums, n, memo);
        
        memo[currentKey] = max(pickHouse, notPickHouse);
            
        return memo[currentKey];
    }
};