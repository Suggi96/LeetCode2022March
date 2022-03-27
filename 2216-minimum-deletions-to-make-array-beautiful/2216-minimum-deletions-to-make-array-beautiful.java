class Solution {
    public int minDeletion(int[] nums) {
        int d = 0;
        int n = nums.length;
        for(int i=0;i<n-1;i++) {
            int newIndex = i-d;
            if(newIndex%2==0 && nums[i]==nums[i+1])
                d++;
        }
        if((n-d)%2==0)
            return d;
        
        return d+1; //n is odd element delete last element so that it doesnt 
                    //affect last element
    }
}