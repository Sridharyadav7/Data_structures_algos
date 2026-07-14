class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for(int i = 1; i < n; i++) {
            if(!isIncreasing && !isDecreasing) return false;
            if(isIncreasing && nums[i-1] > nums[i]) {
                isIncreasing = false;
            } 
            if(isDecreasing && nums[i] > nums[i-1]) {
                isDecreasing = false;
            }
        }
        return isDecreasing || isIncreasing;
    }
}