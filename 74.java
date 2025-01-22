class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix[0].length;
        int m=matrix.length;
        int row=-1;
        int i=0;
        while(i<m){
            if(target>=matrix[i][0] && target<=matrix[i][n-1]){
                row=i;
                break;
            }
            i++;
        }
        if(row==-1) return false;
        int result=binarysearch(matrix[row],0,n-1,target);
        if(result==-1) return false;
        return true;
    }
    public int binarysearch(int[] nums,int low,int high,int target){
        if(low>high) return -1;
        int mid=(low+high)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]<target) return binarysearch(nums,mid+1,high,target);
        else return binarysearch(nums,low,mid-1,target);
    }
}