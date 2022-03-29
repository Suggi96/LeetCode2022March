class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new my_comp());
        StringBuilder ans = new StringBuilder();
        for(Map.Entry<Character, Integer> e: list) {
            int count = 0;
            while(count!=e.getValue()) {
                ans.append(e.getKey());
                count++;
            }
        }
        return ans.toString();
    }
    class my_comp implements Comparator<Map.Entry<Character, Integer>> {
        public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b)         {
            return b.getValue() - a.getValue();
        }
    }
}