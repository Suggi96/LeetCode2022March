class Solution {
    public List<List<Integer>> permute(int[] num) {
       	LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
	res.add(new LinkedList<Integer>());
	for (int n : num) {
		int size = res.size();
		while (size > 0) {
			List<Integer> r = res.pollFirst();
			for (int i = 0; i <= r.size(); i++) {
				List<Integer> temp = new LinkedList<Integer>(r);
				temp.add(i, n);
				res.add(temp);
			}
			size--;
		}
	}
	return res; 
    }
}