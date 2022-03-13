class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        vector<int> jindex;
        for(int j=0;j<nums.size();j++) {
            if(key==nums[j])
                jindex.push_back(j);
        }
        set<int> s;
        for(int i=0;i<nums.size();i++) {
            for(int j: jindex) {
                if(abs(i-j)<=k && nums[j]==key)
                    s.insert(i);
            }
        }
        vector<int> ans;
        for(int i: s) {
            ans.push_back(i);
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};