class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else if (c == '*') {
                stars.push(i);
            }
            else {
                if (!stack.empty()) {
                    stack.pop();
                }
                else if (!stars.empty()) {
                    stars.pop();
                }
                else {
                    return false;
                }
            }
        }

        if (stack.size() == 0) {
            return true;
        }

        while (!stack.empty()) {
            if (!stack.empty() && !stars.empty() && stack.peek() < stars.peek()) {
                stack.pop();
                stars.pop();
            } 
            else {
                return false;
            }
        }

        return true;
    }
}