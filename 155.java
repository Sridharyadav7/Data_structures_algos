//Use stack (different approach)

class MinStack {
    int top=-1;
    List<Integer> stack = new ArrayList<>();
    int min=0;
    public MinStack() {}
    
    public void push(int val) {
        top++;
        stack.add(val);
    }
    
    public void pop() {
            stack.remove(top);
            top--;
    }
    
    public int top() {
        return stack.get(top);
    }
    
    public int getMin() {
        return Collections.min(stack);
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */