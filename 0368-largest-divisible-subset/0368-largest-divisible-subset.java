class Solution {
    int n;
    int dp[];

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, 1);

        // for (int arr[]: dp) {
        //     Arrays.fill(arr, -1);
        // }

        List<Integer> ans = new ArrayList<>();
        int parent[] = new int[n];
        Arrays.fill(parent, -1);
        int maxInd = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] == 0) {
                    if (1 + dp[i] > dp[j]) {
                        dp[j] = 1 + dp[i];
                        parent[j] = i;

                        if (dp[j] > dp[maxInd]) {
                            maxInd = j;
                        }
                    }
                }
            }
        }

        if (maxInd == 0) {
            ans.add(nums[0]);
        }
        else {
            while (maxInd >= 0) {
                ans.add(nums[maxInd]);
                maxInd = parent[maxInd];
            }
        }
        return ans;

    }
    // public int find(int nums[], int prevInd, int i) {
    //     if (i == n) {
    //         return 0;
    //     }

    //     if (dp[prevInd+1][i] != -1) {
    //         return dp[prevInd+1][i];
    //     }

    //     int pick = 0;
    //     int unpick = 0;

    //     if (prevInd == -1 || nums[i] % nums[prevInd] == 0) {
    //         pick = 1 + find(nums, i, i+1);
    //     }
    //     unpick = find(nums, prevInd, i+1);

    //     return dp[prevInd+1][i] = Math.max(pick, unpick);
    // }
}