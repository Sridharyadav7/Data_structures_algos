class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0;
        int neg=1;
        int i=0;
        int[] result=new int[nums.length];
        while(i<nums.length){
            if(nums[i]>0){
                result[pos]=nums[i];
                i++;
                pos+=2;
            }
            else{
                result[neg]=nums[i];
                i++;
                neg+=2;
            }
        }
        return result;
    }
}