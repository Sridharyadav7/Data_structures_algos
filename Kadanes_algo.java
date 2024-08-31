public class Kadanes_algo {
    public static void main(String[] args)
    {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int max=Integer.MIN_VALUE;
        int sum=0;
         if(nums.length==1)
            {
                System.out.println(nums[0]);
            }
            else
            {
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum>max)
            {
                max=sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        }   
        System.out.println(max);     
            }
    }
    
}
