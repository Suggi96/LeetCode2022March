class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new custom_comp());
        int n = costs.length;
        int mincost = 0;
        for(int i=0;i<n/2;i++) {
            mincost += costs[i][0]; //add 0 to len/2 to mincost; indicates A
        }
        for(int i=n/2;i<n;i++) {
            mincost += costs[i][1]; //add next n/2 to n to mincost; indicates B
        }
        return mincost;
    }
    
    class custom_comp implements Comparator<int[]> {
        //to sort in ascending order based on diff [0][0] - [1][1]
        //taking two arrays p1, p2 :
        public int compare(int[] p1, int[] p2) {
            return  (p2[1] - p2[0]) - (p1[1] - p1[0] );
        }
    }
}