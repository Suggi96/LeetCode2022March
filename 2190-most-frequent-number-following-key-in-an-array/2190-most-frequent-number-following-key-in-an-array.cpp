class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        int freq[1001] = {0};
        //count freq of all elements which are targets
        for(int i=1;i<nums.size();i++) {
            if(nums[i-1]==key) {
                freq[nums[i]]++;
            }
        }
        //find element with max frequency in freq array
        int max = 0;
        for(int i=1;i<1001;i++) {
            if(freq[i]>freq[max]) {
                max = i;
            }
        }
        return max;
    }
};