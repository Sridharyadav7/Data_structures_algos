class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int startInd = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                startInd = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        while (startInd != -1 && startInd < n && nums[startInd] == target) {
            ans.add(startInd);
            startInd++;
        }

        return ans;
    }
}