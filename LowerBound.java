import java.util.*;
import java.util.Map.Entry;

public class LowerBound
{
    public static void main(String[] args)
{
    int[] arr={3,5,8,15,19};
    int x=9;
    int low=0;
    int high=arr.length-1;
    ArrayList<Integer> options=new ArrayList<Integer>();
    while(low<=high)
    {
        int mid=(low+high)/2;
        if(arr[mid]>=x)
        {
            options.add(mid);
            high=mid-1;
        }
        else
        {
            low=mid+1;
        }
    }

        System.out.println(Collections.min(options));
    
}
}





