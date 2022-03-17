// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         HashMap<String, Integer> memo = new HashMap<>();
         return maxProfit(0, W, wt, val, n, memo);
    } 
    
    static int maxProfit(int curIdx, int W, int wt[], int val[], int n,
                        HashMap<String, Integer> memo) {
        //base case
        if(curIdx>=n)
            return 0;
        
        int currentProfit = val[curIdx];
        int currentWeight = wt[curIdx];
        
        String curKey = Integer.toString(curIdx) + "-" + Integer.toString(W);
        
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        
        int pick = 0;
        if(currentWeight<=W) {
            pick = currentProfit + 
                   maxProfit(curIdx+1, W-currentWeight, wt, val, n, memo);
        }
        int notPick = maxProfit(curIdx+1, W, wt, val, n, memo);
        
        memo.put(curKey, Math.max(pick, notPick));
        
        return Math.max(pick, notPick);
    }
}


