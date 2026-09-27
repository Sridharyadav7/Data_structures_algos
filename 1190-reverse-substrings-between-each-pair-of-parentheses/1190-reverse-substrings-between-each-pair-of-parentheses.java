class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();

                while (!stack.peek().equals("(")) {
                    sb.append(stack.pop());
                }

                stack.pop();
                stack.push(sb.reverse().toString());
            }
            else {
                stack.push(s.substring(i, i+1));
            }
        }
        
        StringBuilder ans = new StringBuilder();

        while (!stack.empty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}