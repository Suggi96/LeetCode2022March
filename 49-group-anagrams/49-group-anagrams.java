class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            String sortedWord = sort(s);
            if(map.containsKey(sortedWord)) {
               List<String> anaList = map.get(sortedWord);
                anaList.add(s);
                map.put(sortedWord, anaList);
            }
            else {
                List<String> anaList = new ArrayList<>();
                anaList.add(s);
                map.put(sortedWord, anaList);
            }
        }
        for(List<String> list: map.values()) {
            ans.add(list);
        }
        return ans;
    }
    private String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}