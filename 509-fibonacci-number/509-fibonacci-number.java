class Solution {
    public int fib(int n) {
        return solve(n, new HashMap<Integer, Integer>());
    }
    private int solve(int n, HashMap<Integer, Integer> memo) {
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        int curkey = n;
        if(memo.containsKey(curkey)) {
            return memo.get(curkey);
        }
        int a = solve(n-1, memo);
        int b = solve(n-2, memo);
        
        memo.put(curkey, a+b);
        
        return a+b;
    }
}