class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<tokens.length){
            String curr=tokens[i];
            if(curr.equals("+")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num1+num2);
            }
            else if(curr.equals("*")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num1*num2);
            }
            else if(curr.equals("-")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2-num1);
            }
            else if(curr.equals("/")){
                int num1=stack.pop();
                int num2=stack.pop();
                stack.push(num2/num1);
            }
            else{
                stack.push(Integer.parseInt(curr));
            }
            i++;
        }
        return stack.peek();
    }
}