class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(target==nums[mid])
                return true;
            //check if left half is sorted
            if(nums[low]<nums[mid]) {
                //target is out of the left part boundary scope
                if(target < nums[low] || target > nums[mid])
                   low = mid + 1;
                else
                    high = mid - 1; //target lies exactly left boundary
            }
            //if this is true then right half is                                                 sorted
            else if(nums[low]>nums[mid]) {
                //target is out of the right part boundary scope
                if(target < nums[mid] || target > nums[high])
                    high = mid -1;
                else 
                    low = mid + 1; //target lies exactly in right boundary
            }
            //case if nums[mid]==nums[low] // duplicate handling 
            else {
                low++; //1111111222
            }

        }
        return  false;
    }  
}