class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(0);
            }
            else {
                if (stack.peek() == 0) {
                    stack.pop();
                    int val = 1 + stack.pop();
                    stack.push(val);
                }
                else {
                    int val = 2 * stack.pop();
                    val += stack.pop();
                    stack.push(val);
                }
            }
        }
        return stack.peek();
    }
}