class Solution {
    public int pivotIndex(int[] nums) {
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        for(int i=0; i<prefix.length; i++){
            if(i==0 && getSum(prefix, 1, prefix.length-1) == 0) return 0;

            else if(i==prefix.length-1 && getSum(prefix, 0, prefix.length-2) == 0) return prefix.length-1;

            else if(getSum(prefix, 0, i-1) == getSum(prefix, i+1, prefix.length-1)) return i;
        }
    return -1;
    }
    public int getSum(int prefix[], int start, int end){
        if(start>end) return 0;
        if(start == 0) return prefix[end];
        return prefix[end]-prefix[start-1];
    }
}