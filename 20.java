class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        int top=-1;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                top++;
                stack.add(s.charAt(i));
            }
            else if(s.charAt(i)==')' && top>-1 && stack.get(top)=='('){
                stack.remove(top);
                top--;
            }
            else if(s.charAt(i)==']' && top>-1 && stack.get(top)=='['){
                stack.remove(top);
                top--;
            }
            else if(s.charAt(i)=='}' && top>-1 && stack.get(top)=='{'){
                stack.remove(top);
                top--;
            }
            else return false;
            i++;
        }
        return top==-1;
    }
}