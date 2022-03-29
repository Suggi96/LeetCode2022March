class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<Pair<Character, Integer> > list = new ArrayList<>();
        for(Map.Entry<Character, Integer> e: map.entrySet()) {
            list.add(new Pair<Character, Integer>(e.getKey(), e.getValue()) );
        }
        Collections.sort(list, (a, b)-> {
            return b.getValue() - a.getValue();
        });
        StringBuilder ans = new StringBuilder();
        for(Pair<Character, Integer> e: list) {
            int count = 0;
            while(count!=e.getValue()) {
                ans.append(e.getKey());
                count++;
            }
        }
        return ans.toString();
    }
}