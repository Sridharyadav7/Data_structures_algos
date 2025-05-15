class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = nums[left];
        int minlen = Integer.MAX_VALUE;
        while(right < nums.length && left < nums.length){
            if(sum >= target){
                minlen = Math.min(minlen, right-left+1);
                if(sum > target){
                    sum-= nums[left++];
                }
                else{
                    if(right < nums.length-1) sum+= nums[++right];
                    else if(right == nums.length-1) break;
                }
            }
            else{
                if(right < nums.length-1) sum+= nums[++right];
                else if(right == nums.length-1) break;
            }
        }

        if(minlen == Integer.MAX_VALUE) return 0;
        return minlen;
    }
}