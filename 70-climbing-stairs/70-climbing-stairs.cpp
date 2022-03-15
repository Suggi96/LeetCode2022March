class Solution {
public:
    int climbStairs(int n) {
        map<int, int> memo;
        return solve(0, n, memo);
    }
    int solve(int curStair, int targetStair, map<int, int> &memo) {
        if(curStair==targetStair)
            return 1;
        if(curStair>targetStair)
            return 0;
        
        int curKey = curStair;
        if(memo.find(curKey)!=memo.end()) {
            return memo[curKey];
        }
        int oneJump = solve(curStair+1, targetStair, memo);
        int twoJumps = solve(curStair+2, targetStair, memo);
        
        memo[curKey] = oneJump + twoJumps;
        
        return oneJump+twoJumps;
    }
};