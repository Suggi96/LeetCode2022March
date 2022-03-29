// { Driver Code Starts


import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


//import java.util.*;
class Solution{
    public int cutRod(int price[], int n) {
        //code here
        return maxPrice(price, 0, n, new HashMap<String, Integer>());
    }
    private int maxPrice(int[] price, int curIdx, int length 
                        ,HashMap<String, Integer> memo) {
    
    if(curIdx>=price.length)
        return 0;
    
    if(length==0) //cur rod length is 0 return maxprice as 0
        return 0;
    String curKey = curIdx + "-" + length;
    if(memo.containsKey(curKey)) return memo.get(curKey);
    int consider = 0;
    if(curIdx+1<=length) {
        consider = price[curIdx]+ maxPrice(price, curIdx, length-(curIdx+1), memo);
    }

    int notConsider = maxPrice(price, curIdx+1, length, memo);
    memo.put(curKey, Math.max(consider, notConsider));
    
    return memo.get(curKey);
    }
}