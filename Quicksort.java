import java.util.*;

public class Quicksort
{
    public static void main(String[] args)
    {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(4);
    arr.add(2);
    arr.add(1);
    arr.add(5);
    arr.add(6);
    quickSort(arr);
    for(int i=0;i<arr.size();i++)
    {
        System.out.print(arr.get(i)+" ");
    }
    }

    public static void quickSort(ArrayList<Integer> arr){
        int low=0;
        int high=arr.size()-1;
        qs(arr,low,high);
    }
    public static void qs(ArrayList<Integer> arr,int low,int high)
    {
        if(low<high)
        {
            int Pindex=partition(arr,low,high);
            qs(arr,low,Pindex-1);
            qs(arr,Pindex+1,high);
        }
    }
    public static int partition(ArrayList<Integer> arr,int low,int high)
    {
        int pivot=arr.get(low);
        int i=low;
        int j=high;
        while(i<j)
        {
            while(arr.get(i)<=pivot && i<=high-1)
            {
                i++;
            }
            while(arr.get(j)>=pivot && j>=low+1)
            {
                j--;
            }
            if(i<j)
            {
                int temp=arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp=arr.get(low);
        arr.set(low,arr.get(j));
        arr.set(j,temp);
        return j;
    }
}
