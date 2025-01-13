class Solution {
    public int findClosestNumber(int[] nums) {
        int result=Integer.MAX_VALUE;
        int i=0;
        while(i<nums.length){
            int distance=Math.abs(nums[i]);
            if(nums[i]==Math.abs(result)){
                result=nums[i];
            }
            else{
                if(distance<Math.abs(result)){
                    result=nums[i];
                }
            }
            i++;
    }
    return result;
}}