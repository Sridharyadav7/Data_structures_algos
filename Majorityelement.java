
// Moore's Voting algorithm
public class Majorityelement 
{
    public static void main(String[] args)
    {
            int[] nums={2,2,1,1,1,2,2};  
            int n=nums.length;
            int ele=0;
            int count=0;
            for(int i=0;i<n;i++)
            {
                if(count==0)
                {
                    ele=nums[i];
                    count++;
                }
                else if(nums[i]==ele)
                {   
                    count++;
                }
                else
                {
                    count--;
                }
            }

        int count1=0;// Verity if the element is majority or not
        for(int i=0;i<n;i++)
        {
            if(nums[i]==ele)
            {
                count++;
            }
        }
        if(count1>n/2)
        {
            System.out.println("Majority element is" + ele);
        }
        else 
        {
            System.out.println("No Majority element");
        }
            
        
    }
    
}
