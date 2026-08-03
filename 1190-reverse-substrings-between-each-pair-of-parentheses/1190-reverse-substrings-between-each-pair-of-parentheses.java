class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push(curr);
                curr = new StringBuilder();
            }
            else if(c == ')') {
                curr.reverse();
                curr = stack.pop().append(curr);
            }
            else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}