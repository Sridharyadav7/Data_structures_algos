class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;

        for(int i = 0; i < n; i++) {
            // treat every zero as -1 so that when currSum = 0, that subarray is valid
            if(nums[i] == 0) {
                currSum -= 1;
            }
            else {
                currSum += 1;
            }

            if(map.containsKey(currSum)) {
                // if a sum is found again then the subarray is valid 
                // because curr index - sum found at prev index = 0 -> valid subarray
                maxLen = Math.max(maxLen, i - map.get(currSum));
            }
            else {
                map.put(currSum, i);
            }
        }
        return maxLen;
    }
}