class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> freqT = new HashMap<>();
        HashMap<Integer, Integer> freqB = new HashMap<>();
        int maxFreq_element_T = maxFreq_StoreFreq(freqT, tops);
        int maxFreq_element_B = maxFreq_StoreFreq(freqB, bottoms);
        
        System.out.println("mfT "+maxFreq_element_T);
        System.out.println("mfB "+maxFreq_element_B);

        //iterate through tops and bottoms , find swaps to make entire top or bottom equal
        //return min of both swaps as answer
        int swapsT = makeEqual(tops, bottoms, maxFreq_element_T);
        int swapsB = makeEqual(bottoms, tops, maxFreq_element_B);
        
        System.out.println("swapT "+ swapsT);
        System.out.println("swapB "+ swapsB);
        if(swapsT==0 || swapsB==0)
            return 0;
        
        if(swapsT==999 && swapsB==999)
            return -1;
        
        
        
        return Math.min(swapsT, swapsB);
        // return 0;
    }
    
    private int makeEqual(int[] source, int[] dest, int k) {
        //goal is to make source equal with k
        int swap = 0;
        int i = 0, n = source.length;
        while(i<n) {
            if(source[i]!=k && dest[i]==k) {
                swap++;
                i++;
            }
            else if(source[i]==k) {
                i++;
                continue;
            }
            else 
                return 999;
        }
   
        return swap;
        
    }
    private int maxFreq_StoreFreq(HashMap<Integer, Integer> map, int[] arr) {
        for(int i: arr) {
          //  System.out.print(i+" ");
            map.put(i, map.getOrDefault(i, 0)+1);
        }
      //  System.out.println();
        //find maxfreq element in map
        int maxi = Integer.MIN_VALUE;
        int maxElement = 0;
        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            int freq = e.getValue();
            if(freq>maxi) {
                maxi = freq;
                maxElement = e.getKey();
            }
        }
        return maxElement;
    }
}