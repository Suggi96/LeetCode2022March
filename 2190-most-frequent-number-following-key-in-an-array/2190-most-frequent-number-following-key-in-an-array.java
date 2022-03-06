class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]==key) {
                map.put(nums[i+1], map.getOrDefault(nums[i+1], 0)+1);
            }
        }
        int target = 0;
        int max = -1;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue() > max) {
                max = e.getValue();
                target = e.getKey();
            }
        }
        return target;
    }
}