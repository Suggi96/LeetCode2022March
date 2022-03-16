class Solution {
    public int tribonacci(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return tri(n, memo);
    }
    private int tri(int n, HashMap<Integer, Integer> memo) {
        if(n==0)
            return 0;
        if(n==1 || n==2)
            return 1;
        int curKey = n;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        int a = tri(n-1, memo);
        int b = tri(n-2, memo);
        int c = tri(n-3, memo);
        
        memo.put(curKey, a+b+c);
        
        return memo.get(curKey);
    }
}