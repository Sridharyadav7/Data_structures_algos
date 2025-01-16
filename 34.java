class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==1 && nums[0]==target) return new int[]{0,0};
        if(nums.length==1 && nums[0]!=target) return new int[]{-1,-1};
        int result=binarysearch(nums,0,nums.length-1,target);
        if(result==-1) return new int[]{-1,-1};
        int start=result;
        int end=result;
        while(start>=1 && nums[start-1]==target){
            start--;
        }
        while(end<nums.length-1 && nums[end+1]==target){
            end++;
        }
        return new int[]{start,end};
    }

    public int binarysearch(int[] nums,int low,int high, int target){
        if(low>high) return -1;
        int mid=(low+high)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]<target) return binarysearch(nums,mid+1,high,target);
        else return binarysearch(nums,low,mid-1,target);
    }
}