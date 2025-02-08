class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int sum=0;
        while(i<operations.length){
            String s=operations[i];
            if(s.equals("C")){
                stack.pop();
            }
            else if(s.equals("D")){
                stack.push(stack.peek()*2);
            }
            else if(s.equals("+")){
                int pop=stack.pop();
                int new_ele=pop+stack.peek();
                stack.push(pop);
                stack.push(new_ele);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
            i++;
        }
        while(!stack.empty()){
            int pop=stack.pop();
            sum=sum+pop;
        }
        return sum;
    }
}