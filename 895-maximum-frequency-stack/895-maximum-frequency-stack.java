class FreqStack {
    Map<Integer, Integer> map = null;
    List<Stack<Integer>> stlist = null;
    public FreqStack() {
        map = new HashMap<>();
        stlist = new ArrayList<>();
    }
    //update freq map
    //store val in stlist with index freq -1 stack
    //we need to create new stack only if freq - 1 >= stlist.size() 
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0)+1);
        int freq = map.get(val);
        if(freq-1 >= stlist.size()) {
            stlist.add(new Stack<Integer>());
        }
        stlist.get(freq-1).add(val);
    }
    //update freq map 
    //remove freq -1 index's stack top element
    //if st.size at freq-1 becomes 0 decrease stlist size by 1 ie remove the stack itself at that index
    public int pop() {
        int size = stlist.size();
        int popped = stlist.get(size-1).pop();
        if(stlist.get(size-1).empty()) {
            stlist.remove(size-1);
        }
        map.put(popped, map.get(popped)-1);
        if(map.get(popped)==0)
            map.remove(popped);
        return popped;   
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */