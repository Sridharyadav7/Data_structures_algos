class Solution {
    public int countHousePlacements(int n) {
        int MOD = 1_000_000_007;
        int prev1 = 1;
        int prev2 = 2;

        for(int i = 2; i <= n; i++) {
            int curr = (prev1 + prev2) % MOD;
            prev1 = prev2;
            prev2 = curr;
        } 

        return (int) ((long) prev2 * prev2 % MOD);
    }
}