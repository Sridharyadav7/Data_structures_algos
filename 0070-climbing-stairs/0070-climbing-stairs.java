class Solution {
    public int climbStairs(int n) {
        if(n < 4) return n;
        
        int curr = 0;
        int prev1 = 1;
        int prev2 = 2;

        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return curr;
    }
}