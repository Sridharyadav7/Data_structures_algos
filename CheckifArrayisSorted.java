public class CheckifArrayisSorted
{
    public static void main(String[] args)
    {
        int[] arr={1,2,3,4,5};
        int result=check(arr,arr.length);
        System.out.print(result);

    }
    public static int check(int[] a, int n)
    {
        int result=1;
        if(n==0 || n==1)
            return 0;
        else
        {
            for(int i=0;i<n-1;i++)
            {
                if(a[i+1]<a[i])
                    result=0;
            }
            return result;
        }
    }
  
}
