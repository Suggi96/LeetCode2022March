class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        //initially slow and fast point same nums[0]. so to enter loop i use do while
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast); //doing this because loop should run atleast once
        
        slow = nums[0];
        while(slow!=fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}