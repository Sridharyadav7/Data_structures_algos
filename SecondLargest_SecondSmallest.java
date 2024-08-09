import java.util.*;
import java.util.Map.Entry;

public class SecondLargest_SecondSmallest
{
    public static void main(String[] args)
{
    int[] arr={4,5, 3, 6, 7};
    int max=arr[0];
    int max2=0;
    int n=arr.length;
    int min=arr[0];
    for(int i=0;i<arr.length;i++)
    {
        if(arr[i]>max)
        {
            max2=max;
            max=arr[i];
        }
        else if(arr[i]>=max2 && arr[i]<max)
            {
                max2=arr[i];
            }
    }
    int min2=max;
    for(int i=0;i<n;i++)
    {
        if(arr[i]<min)
        {
            min2=min;
            min=arr[i];
        }
        else if(arr[i]>min && arr[i]<=min2)
        {
            min2=arr[i];
        }
    }
    System.out.println(max2+" "+min2);
}
}


