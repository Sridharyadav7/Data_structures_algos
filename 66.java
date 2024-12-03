public class Solution{
    public static void main(String[] args) {
        int[] nums={4,3,2,1};
        int[] result=increment(nums,nums.length-1);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
    public static int[] increment(int[] nums, int index){
        if(index==0 && nums[index]==9){
            int[] new_arr=new int[nums.length+1];
            new_arr[0]=1;
            nums[0]=0;
            for(int i=1;i<new_arr.length;i++){
                new_arr[i]=nums[i-1];
            }
            return new_arr;
        }
        else if(nums[index]==9){
            nums[index]=0;
            return increment(nums,--index);
        }
        else{
            int temp=nums[index];
            nums[index]=++temp;
            return nums;
    }
}
}
