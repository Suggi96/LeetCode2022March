// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
     int knapSack(int N, int capacity, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N][capacity+1];
        for(int i=0;i<N;i++)
            for(int j=0;j<capacity+1;j++)
                dp[i][j] = -1;
  
        return maxProfit(0, capacity, val, wt, N, dp);
    }
    
    private int maxProfit(int curItem, int capacity, int[] val, int[] wt, int N,
                          int[][] dp)
    {
        if(curItem==N)
            return 0;
        if(capacity==0)
            return 0;
            
        if(dp[curItem][capacity]!=-1)
            return dp[curItem][capacity];
        
        int currentProfit = val[curItem];
        int currentWeight = wt[curItem];
        
        int consider = 0;
        
        if(currentWeight<=capacity) {
            consider = currentProfit + maxProfit(curItem, capacity-currentWeight, 
                                                val, wt, N, dp);
        }
        int notconsider = maxProfit(curItem+1, capacity, val, wt, N, dp);
        
        dp[curItem][capacity] = Math.max(consider, notconsider);
        
        return dp[curItem][capacity];
    }
}