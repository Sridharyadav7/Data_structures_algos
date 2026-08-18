class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int maxEle = 0;
        for(int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            maxEle = Math.max(maxEle, nums[i]);
        }

        if(k == 1) {
            int ans = -1;
            for(int key : map.keySet()) {
                if(map.get(key) == 1) {
                    ans = Math.max(key, ans);
                }
            }
            return ans;
        }
        else if(k == n) {
            return maxEle;
        }
        else {
            if(map.get(nums[0]) == 1 && map.get(nums[n-1]) == 1) {
                return Math.max(nums[0], nums[n-1]);
            }
            else if(map.get(nums[0]) == 1) {
                return nums[0];
            }
            else if(map.get(nums[n-1]) == 1) {
                return nums[n-1];
            }
            else return -1;
        }
    }
}