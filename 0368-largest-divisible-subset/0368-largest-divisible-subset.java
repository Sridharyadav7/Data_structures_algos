class Solution {
    int n;
    int dp[][];

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        dp = new int[n+1][n+1];

        for (int arr[]: dp) {
            Arrays.fill(arr, -1);
        }

        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int prevInd = -1;

        while (i < n) {
            int best = find(nums, prevInd, i);
            int pick = 0;

            boolean canPick = prevInd == -1 || nums[i] % nums[prevInd] == 0;

            if (canPick) {
                pick = 1 + find(nums, i, i+1);
            }

            if (canPick && pick == best) {
                ans.add(nums[i]);
                prevInd = i;
            }
            i++;
        }
        return ans;
    }
    public int find(int nums[], int prevInd, int i) {
        if (i == n) {
            return 0;
        }

        if (dp[prevInd+1][i] != -1) {
            return dp[prevInd+1][i];
        }

        int pick = 0;
        int unpick = 0;

        if (prevInd == -1 || nums[i] % nums[prevInd] == 0) {
            pick = 1 + find(nums, i, i+1);
        }
        unpick = find(nums, prevInd, i+1);

        return dp[prevInd+1][i] = Math.max(pick, unpick);
    }
}