import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    while(T-- > 0) {
	        int n = 0;
	        n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i=0;i<n;i++) {
	            int val = sc.nextInt();
	            arr[i] = val;
	        }
	        sortAndPrint(arr);
	    }
	    sc.close();
	 }
	 private static void sortAndPrint(int[] arr) {
	     HashMap<Integer, Integer> map = new HashMap<>();
	     for(int i: arr)
	        map.put(i, map.getOrDefault(i, 0)+1);
	     List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
	     Collections.sort(list, (a,b) -> {
	        if(a.getValue()==b.getValue())
	            return a.getKey() - b.getKey();
	       return b.getValue() - a.getValue();
	     });
	     for(Map.Entry<Integer, Integer> e: list) {
	         int count = e.getValue();
	         for(int i=0;i<count;i++)
	            System.out.print(e.getKey()+" ");
	     }
	     System.out.println();
	 }
}