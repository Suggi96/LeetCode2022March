class Solution {
public:
    int climbStairs(int n) {
        unordered_map<int, int> mp;
       return totalWays(0, n, mp); 
    }
    int totalWays(int idx, int n, unordered_map<int, int> &mp) {
        if(idx==n)
            return 1;
        if(idx>n)
            return 0;
        
        int curKey = idx;
        if(mp.find(curKey)!=mp.end())
            return mp[curKey];
        
        int oneJump = totalWays(idx+1, n, mp);
        int twoJump = totalWays(idx+2, n, mp);
        
        mp[curKey] = oneJump + twoJump;
        
        return mp[curKey];
    }
};