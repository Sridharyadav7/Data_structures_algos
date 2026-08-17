class Solution {
    public String removeStars(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '*' && !stack.empty()) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}