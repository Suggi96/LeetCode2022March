class Solution {
    public List<Integer> partitionLabels(String s) {
        int end_idx[] = new int[26]; //array to store last occurance of each char in string
        for(int i=0;i<s.length();i++)
        {
            end_idx[s.charAt(i) - 'a']=i;
        }
        List<Integer> res = new ArrayList<>();
        int start=0,end=0;
        for(int i=0;i<s.length();i++)
        {
            end = Math.max(end, end_idx[s.charAt(i) - 'a']);
            if(i==end)
            {
                res.add(i-start+1); //start+1 because 0 based indexing and we need length of                                       partition
                start=i+1;
            }
        }
        return res;
    }
}