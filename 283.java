class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer=new int[nums.length];
        int prod=product(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            if(prod==0 && nums[i]==0){
                if(i==0){
                    answer[i]=product(nums,i+1,nums.length-1);
                }
                else if(i==nums.length-1){
                    answer[i]=product(nums,0,i-1);
                }
                else{
                    answer[i]=product(nums,0,i-1)*product(nums,i+1,nums.length-1);
                }
            }
            else if(prod==0 && nums[i]!=0){
                answer[i]=0;
            }
            else if(nums[i]==0){
                answer[i]=0;
            }
            else{
                answer[i]=prod/nums[i];
            }
        }
        return answer;
    } 
    

    public int product(int[] arr,int low,int high){
        int value=1;
        for(int i=low;i<=high;i++){
            value=value*arr[i];
        }
        return value;
    }
}