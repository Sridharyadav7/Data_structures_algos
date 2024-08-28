import java.util.*;

public class Twosum {
 public static void main(String[] args)
 {
    int[] nums={3,2,4};
    int target=6;
    int[] temp = new int[nums.length]; 
    for(int k=0;k<temp.length;k++)
    {
         temp[k]=nums[k];
    }
    Arrays.sort(nums);
    int i=0;
    int first=0;
    int second=0;
    int[] sums = new int[2];
    int j=nums.length-1;
    while(i<=j)
    {
     int sum=nums[i]+nums[j];
     if(sum<target)
     {
         i++;
     }
     else if(sum>target)
     {
         j--;
     }
     else if(sum==target)
     {
         first=nums[i];
         second=nums[j];
         break;
     }
    } 
    for(int k=0;k<temp.length;k++)
    {
         if(temp[k]==first)
         {
             sums[0]=k;
             break;
         }
    }
    for(int k=temp.length-1;k>=0;k--)
    {
         if(temp[k]==second)
         {
             sums[1]=k;
             break;
         }
    }    
 }
}
