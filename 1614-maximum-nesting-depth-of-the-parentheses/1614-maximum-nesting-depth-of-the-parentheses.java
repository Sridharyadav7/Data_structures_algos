class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            
            if (s.charAt(i) == '(') {
                stack.push('(');
                ans = Math.max(ans, stack.size());
            }
            else if (s.charAt(i) == ')') {
                stack.pop();
            }
        }
        return ans;
    }
}