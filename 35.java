class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==1){
            if(target>nums[0]){
                return nums.length;
            }
            else return 0;
        }
        int result=binarysearch(nums,0,nums.length-1,target);
        if(result==-1){
            int pos=position(nums,0,nums.length,target);
            return pos;
        }
        else return result;
        
    }
    public int binarysearch(int[] nums,int low,int high,int target)
    {
        int mid=(low+high)/2;
        if(low>high){
            return -1;
        }
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]>target){
            return binarysearch(nums,low,mid-1,target);
        }
        else if(nums[mid]<target){
            return binarysearch(nums,mid+1,high,target);
        }
        else return -1;
    }

    public int position(int[] nums,int low,int high,int target){
        
        if(nums[0]>target){
            return 0;
        }
        if(nums[nums.length-1]<target){
            return nums.length;
        }
        int mid=(low+high)/2;
        if(nums[mid]<target && nums[mid+1]>target)
        {
            return mid+1;
        }
        else if(nums[mid]>target){
            return position(nums,low,mid-1,target);
        }
        else return position(nums,mid+1,high,target);
    }
}