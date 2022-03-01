class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> ans(n+1); //vector from o to n indices will have size as n+1
        ans[0] = 0; // index 0 will have 0 set bits
        for(int i=1;i<=n;i++) {
            ans[i] = ans[i/2] + i%2;
        }
        return ans;
    }
};