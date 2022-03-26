class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) 
            map.put(i, map.getOrDefault(i, 0)+1);
        //creating a 2d array with a,b where a = val(freq) and b = key 
        List<List<Integer>> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            list.add(new ArrayList<>(Arrays.asList(e.getValue(), e.getKey())));
        }
        Collections.sort(list, new myComp());
        int[] ans = new int[nums.length];
        int idx = 0;
        for(List<Integer> l: list) {
            int freq = l.get(0);
            int i = 0;
            while(i++<freq)
                ans[idx++] = l.get(1);
        }
        return ans;
    }
    class myComp implements Comparator<List<Integer>> {
        public int compare(List<Integer> a, List<Integer> b) {
            if(a.get(0)==b.get(0))
                return b.get(1) - a.get(1);
            return a.get(0) - b.get(0);
        }
    }
}