// { Driver Code Starts
// Driver Code
import static java.lang.System.out;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int T = in.nextInt(); T-->0;) {
            int n = in.nextInt();
            
            Geeks obj = new Geeks();
            out.println(obj.count(n));
        }
    }
}// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        HashMap<String, Long> memo = new HashMap<String, Long>();
        int arr[] = {3,5,10};
        return totalWays(0, n, arr, memo);
    }
    public long totalWays(int i, int amount, int[] arr, HashMap<String, Long> memo) {
        
        if(i>=arr.length) 
            return 0;
        if(amount==0)
            return 1;
        String curKey = i + "-" + amount;
        if(memo.containsKey(curKey))
            return memo.get(curKey);
        long pick = 0;
        if(arr[i]<=amount) {
            pick = totalWays(i, amount-arr[i], arr, memo);
        }
        long notPick = totalWays(i+1, amount, arr, memo);
        memo.put(curKey, pick+notPick);
        
        return memo.get(curKey);
}
}