class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int most_water=Integer.MIN_VALUE;
        while(left<right){
            if((Math.min(height[left],height[right])*(right-left))>most_water){
                most_water=Math.min(height[left],height[right])*(right-left);
            }
            if(height[right]>height[left]){
                left++;
            }
            else right--;
        }
        return most_water;
        
    }
}