class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ')' && !stack.empty() && stack.peek() == '(' ||
                c == ']' && !stack.empty() && stack.peek() == '[' ||
                c == '}' && !stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } 
            else if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else {
                return false;
            }
        }
        return stack.empty();
    }
}