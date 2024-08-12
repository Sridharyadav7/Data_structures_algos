import java.util.*;

public class MoveZeroestoEnd
{
    public static void main(String[] args)
{
    int[] arr={ 1, 2, 0, 0, 2, 3};
    int n=arr.length;
    int i=0;
    int j=1;
    while(j<n)
    {
        if(arr[i]==0)
        {
            if(arr[j]!=0)
            {
                arr[i]=arr[j];
                arr[j]=0;
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }
        else
        {
            i++;
            j++;
        }
    }
    for(int k=0;k<n;k++)
    {
        System.out.print(arr[k]+" ");
    }
}
}



