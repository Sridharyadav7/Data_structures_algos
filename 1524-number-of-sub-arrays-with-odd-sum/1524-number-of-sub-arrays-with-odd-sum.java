class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int prefix = arr[0];
        int odds = 0;
        int evens = 0;
        int res = 0;
        int MOD = 1_000_000_007;

        if (prefix % 2 == 0) {
            evens = 1;
        }
        else {
            res++;
            odds = 1;
        }

        for (int i = 1; i < n; i++) {
            int curr = arr[i] + prefix;
            
            evens = evens + (curr % 2 == 0 ? 1 : 0);
            odds = odds + (curr % 2 == 1 ? 1 : 0);

            if (curr % 2 == 0) {
                res = (res + odds) % MOD;
            }
            else {
                res += 1;
                res = (res + evens) % MOD;
            }

            prefix = curr;
        }

        return res;
    }
}