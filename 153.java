class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int low=0;
        int high=n-1;
        return bs(nums,low,high);
    }
    public int bs(int[] nums,int low,int high){
        if(low==high) return nums[low];
        int mid=(low+high)/2;
        if(nums[mid]>nums[high]) return bs(nums,mid+1,high);
        else return bs(nums,low,mid);
    }
}