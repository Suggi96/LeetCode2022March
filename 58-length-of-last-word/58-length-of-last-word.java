class Solution {
    public int lengthOfLastWord(String s) {
        String[] splited = s.split("\\s+");
        String ans = splited[splited.length-1];
        return ans.length();
    }
}