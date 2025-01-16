class Solution {
    public boolean canJump(int[] nums) {
        int curr=nums.length-1;
        int i=nums.length-2;
        while(i>=0){
            if(nums[i]>=(curr-i)){
                curr=i;
            }
            i--;
        }     
        if(curr==0) return true;
        else return false;
    }
}