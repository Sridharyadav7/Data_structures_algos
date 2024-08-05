import java.util.*;

public class Reversearray_usingrecursion
{
    public static void main(String[] args)
{
    Scanner sc=new Scanner(System.in);
    int[] nums={5,4,3,2,1};
    recursive obj=new recursive();
    int[] reverse=obj.print(0,nums.length-1,nums);
    for(int k=0;k<reverse.length;k++)
    {
        System.out.print(reverse[k]+" ");
    }
}
}

class recursive
{
    int temp;
    public int[] print(int i,int j,int[] nums)
    {
        if(i>=j)
        {
            return nums;
        }
        else
        {
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            return print(i+1,j-1,nums);
        }
    }
}
