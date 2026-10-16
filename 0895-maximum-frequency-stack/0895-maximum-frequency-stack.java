class FreqStack {
    Map<Integer, Integer> map;
    List<List<Integer>> list;

    public FreqStack() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int freq = map.get(val);

        if (list.size() < freq) {
            list.add(new ArrayList<>());
        } 
        list.get(freq - 1).add(val);
    }
    
    public int pop() {
        int len = list.get(list.size() - 1).size();
        int val = list.get(list.size() - 1).get(len - 1);
        list.get(list.size() - 1).remove(len - 1);

        if (list.get(list.size() - 1).size() == 0) {
            list.remove(list.size() - 1);
        }

        map.put(val, map.get(val) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */