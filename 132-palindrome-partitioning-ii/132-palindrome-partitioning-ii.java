class Solution {
    public int minCut(String s) {
        HashMap<String, Integer> memo = new HashMap<>();
        return miniCuts(s, 0, s.length()-1, memo);
        
    }
    private int miniCuts(String s, int start, int end, HashMap<String, Integer> memo) {
        //base case 
        if(isPalindrome(s, start, end) || start==end)
            return 0;
        
        if(start>end)
            return 0;
   
        String curKey = start + "-" + end;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int ans = Integer.MAX_VALUE;
             //never cut at last char ie end because if u cut u will get original string                    itself
        for(int currentCut=start; currentCut<=end-1; currentCut++) {
            if(isPalindrome(s, start, currentCut)==true) {
                //we add 1 because i made an intelligent cut and left half ie start to 
                //currentCut is palindrome. Next call recursion with new 
                //start = currentCut + 1
                int rightHalf = 1 + miniCuts(s, currentCut+1, end, memo);
                ans = Math.min(ans, rightHalf);
            }
        }
        memo.put(curKey, ans);
        return memo.get(curKey);
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}