class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        vector<int> ans;
        queue<int> q;
        for(int j=0;j<nums.size();j++) {
            if(nums[j]==key)
                q.push(j);
        }
        for(int i=0;i<nums.size() && q.size()>0;i++) {
         //    if(q.empty()) break;
            int j = q.front();
            if(abs(i-j)<=k) 
                ans.push_back(i);
            else {
                if(i>j) {
                    q.pop();
                
                //start scanning from current index 
                    i--;
                }
            }
        }
        return ans;
    }
};