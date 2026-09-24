class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (sum(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }
    public int sum(int num) {
        int s = 0;

        while (num > 0) {
            s += num % 10;
            num /= 10;
        }

        return s;
    }
}