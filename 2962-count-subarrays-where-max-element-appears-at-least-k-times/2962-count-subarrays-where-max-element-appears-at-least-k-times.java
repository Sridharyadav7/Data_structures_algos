class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int n = nums.length;
        int maxEle = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            maxEle = Math.max(maxEle, nums[i]);
        }

        Queue<Integer> index = new LinkedList<>();
        for(int right = 0; right < n; right++) {
            if(nums[right] == maxEle) {
                index.add(right);
                cnt++;
            }
            if(cnt == k) {
                ans += index.peek() + 1;
            }
            if(cnt > k) {
                index.poll();
                cnt--;
                ans += index.peek() + 1;
            }
        }
        return ans;
    }
}