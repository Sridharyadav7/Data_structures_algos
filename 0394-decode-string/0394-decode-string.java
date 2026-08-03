class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Integer> number = new Stack<>();
        Stack<String> res = new Stack<>();
        boolean prevDigit = false;

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) {
                if(number.isEmpty() || !prevDigit) {
                    number.push(Character.digit(c, 10));
                }
                else {
                    int val = number.pop();
                    number.push(val * 10 + Character.digit(c, 10));
                }
                prevDigit = true;
            }
            else if(Character.isLowerCase(c) || c == '[') {
                res.push(String.valueOf(c));
                prevDigit = false;
            }
            else {
                StringBuilder curr = new StringBuilder();
                while(!res.empty() && !res.peek().equals("[")) {
                    curr.insert(0, res.pop());
                }
                res.pop();
                int val = number.pop();
                String str = curr.toString();
                for (int ind = 1; ind < val; ind++) {
                    curr.append(str);
                }
                res.push(curr.toString());
                prevDigit = false;
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!res.empty()) {
            ans.insert(0, res.pop());
        }
        return ans.toString();
    }
}