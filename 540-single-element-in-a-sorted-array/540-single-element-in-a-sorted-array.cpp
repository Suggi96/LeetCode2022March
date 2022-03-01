class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        int low = 0;
        int high = nums.size()-1;
        //boundary cases
        if(high==0)
            return nums[0];
        //if first element is unique return it
        if(nums[low]!=nums[low+1])
            return nums[low];
        //if last element is unique return it
        if(nums[high]!=nums[high-1])
            return nums[high];
        
        //binary search
        while(low<=high) {
            int mid = low + (high-low)/2;
            //check if mid is unique, if yes return it
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            //make decision by checking if mid index value
            //if mid is even then nums[mid]==nums[mid+1]
            //if mid is odd then nums[mid]==nums[mid-1]
            //if any of above condition is satisfied move low
            if(mid%2==0 && nums[mid]==nums[mid+1] ||
              mid%2==1 && nums[mid]==nums[mid-1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
        
    }
};