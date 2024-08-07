import java.util.*;

public class FrequencyCount_Arrayelements
{
    public static void main(String[] args)
{
    int N = 4; 
    int[] arr = {3,3,3,3};
    int p = 3;
    Solution obj=new Solution();
    arr=obj.frequencyCount(arr,N,p);
    for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
}
}

class Solution{
    public static int[] frequencyCount(int arr[], int N, int P)
    {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=1;i<=P;i++)
        {
            map.put(i,0);
        }
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i], map.get(arr[i])+1);
            }
        }
        for(int i=0;i<N;i++)
        {
            if(i<map.size())
            {
                arr[i]=map.get(i+1);
            }
            else
            {
                arr[i]=0;
            }
        }
        return arr;
    }
}

