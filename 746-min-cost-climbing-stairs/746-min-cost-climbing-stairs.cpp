class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        unordered_map<int, int> mp1;
        unordered_map<int, int> mp2;
        
        int ans1 = minCost(0, cost, mp1);
        int ans2 = minCost(1, cost, mp2);
        
        return min(ans1, ans2);
    }
    
    int minCost(int idx, vector<int> &cost, unordered_map<int, int> &mp)
    {
        if(idx >= cost.size()) return 0;
        
        int curKey = idx;
        if(mp.find(idx)!=mp.end())
            return mp[idx];
        
        int oneJump = cost[idx] + minCost(idx+1, cost, mp);
        int twoJumps = cost[idx] + minCost(idx+2, cost, mp);
        
        mp[curKey] = min(oneJump, twoJumps);
        return mp[curKey];
        
    }
};